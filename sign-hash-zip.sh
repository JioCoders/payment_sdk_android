#!/bin/bash

# Exit if any command fails
set -e

# ==== Make executable: chmod +x sign-hash-zip.sh
# ==== Run It: ./sign-hash-zip.sh
# ==== Configuration ====
ARTIFACT_BASE="PaymentSDK"
VERSION="1.0.0"
ZIP_NAME="release.zip"

# List of artifact files to process
FILES=(
  "$ARTIFACT_BASE-$VERSION.aar"
  "$ARTIFACT_BASE-$VERSION.pom"
  "$ARTIFACT_BASE-$VERSION.jar"
  "$ARTIFACT_BASE-$VERSION-sources.jar"
  "$ARTIFACT_BASE-$VERSION-javadoc.jar"
)

echo "📦 Preparing artifacts for $ARTIFACT_BASE:$VERSION"

# Clean any existing zip
rm -f "$ZIP_NAME"

# ==== Signing & Hashing ====
for file in "${FILES[@]}"; do
  if [ -f "$file" ]; then
    echo "🔐 Signing: $file"

    # GPG ASCII-armored detached signature
    gpg --armor --detach-sign "$file"

    echo "🔢 Generating checksums: $file"
    # Generate checksums
    md5sum "$file" | awk '{print $1}' > "$file.md5"
    sha256sum "$file" | awk '{print $1}' > "$file.sha256"

    # For .asc file
    if [ -f "$file.asc" ]; then
      md5sum "$file.asc" | awk '{print $1}' > "$file.asc.md5"
      sha256sum "$file.asc" | awk '{print $1}' > "$file.asc.sha256"
    fi
  else
    echo "⚠️  Skipping missing file: $file"
  fi
done

echo "✅ All done! Signatures and checksums created."

# ==== Zipping ====
echo "📦 Creating $ZIP_NAME..."
zip "$ZIP_NAME" $ARTIFACT_BASE-$VERSION*

echo "✅ Done: $ZIP_NAME ready for upload."

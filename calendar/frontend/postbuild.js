const path = require('path');
const fs = require('fs-extra');

const BUILD_DIR = path.join(__dirname, './build/static');
const PUBLIC_DIR = path.join(__dirname, '../src/main/resources/static');

const BUILDHTML_DIR = path.join(__dirname, './build');
const PUBLICHTML_DIR = path.join(__dirname, '../src/main/resources/templates');


fs.emptyDirSync(PUBLIC_DIR);
fs.copySync(BUILD_DIR, PUBLIC_DIR);

fs.emptyDirSync(PUBLICHTML_DIR);
fs.copySync(BUILDHTML_DIR, PUBLICHTML_DIR);
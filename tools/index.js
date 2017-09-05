const yaml = require('js-yaml');
const fs = require('fs-extra');

let oldTrans;
try {
  const old = fs.readFileSync('../src/main/resources/config.yml', "utf8");
  oldTrans = yaml.safeLoad(old);
} catch (error) {
  return console.log(error);
}

const newTrans = {
  config: oldTrans.config,
  item: {},
};

let newLables;
try {
  newLables = fs.readFileSync('./material.txt', "utf8").split('\r\n');
} catch (error) {
  return console.log(error);
}

for (let label of newLables) {
  newTrans.item[label] = oldTrans.item[label] ? oldTrans.item[label] : '';
}

try {
  const newYaml = yaml.safeDump(newTrans);
  fs.writeFileSync('../src/main/resources/config.yml', newYaml, "utf-8");
} catch (error) {
  return console.log(error);
}
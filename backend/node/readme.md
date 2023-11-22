# NodeJS

## Hello World

```javascript
console.log('Hello, World')
```

## OS Module

```javascript
const os = os.require('os')

console.log(os.type())
console.log(os.version())
console.log(os.homedir())
```

## Path Module

```javascript
const os = os.require('os')

console.log(__filename)
console.log(__dirname)

console.log(path.dirname(__filename))
console.log(path.basename(__filename))
console.log(path.extname(__filename))

console.log(path.parse(__filename))
```





```shell
pnpm install --save-dev jest typescript ts-jest @types/jest
```


## Create the config file

```shell
pnpm ts-jest config:init
```


`jest.config.js`

```js
module.exports = {
	preset: "ts-jest",
	testEnvironment: "node"
}
```


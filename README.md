# leva-uix

## About

This project is a rewrite of the [Leva.cljs library]([url](https://github.com/mentat-collective/Leva.cljs)) that replaces [Reagent]([url](https://reagent-project.github.io/)) with [UIx]([url](https://pitch-io.github.io/uix/docs/))

Much of the code in `src/leva` is unchanged from the original project. The main changes have happened in `src/leva/core.cljs` where we replace Reagent syntax with UIx syntax.

In `src/app` we run a small demo (TODO, not yet working) demo-ing the use of the UIx Leva panel.

## TODO

- [ ] get working demo with UIx, figure out how to sync atom state with React state.

## Development

```shell
yarn # install NPM deps
yarn dev # run dev build in watch mode with CLJS REPL
```

## Production
```shell
yarn release # build production bundle
```

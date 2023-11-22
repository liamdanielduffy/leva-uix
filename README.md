# leva-uix

## About

This project is a rewrite of the [Leva.cljs library](https://github.com/mentat-collective/Leva.cljs) that replaces [Reagent](https://reagent-project.github.io/) with [UIx](https://pitch-io.github.io/uix/docs/)

Much of the code in `src/leva` is unchanged from the original project. The main changes have happened in `src/leva/core.cljs` where we replace Reagent syntax with UIx syntax.

In `src/app` we run a small demo demo-ing the use of the UIx Leva panel. A custom hook called "use-reactive-atom" makes sure that whenever Leva panel updates the value of an atom, React re-renders the component. 

## Development

```shell
yarn # install NPM deps
yarn dev # run dev build in watch mode with CLJS REPL
```

## Production
```shell
yarn release # build production bundle
```

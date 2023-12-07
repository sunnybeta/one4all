# React


## Init

```bash
npm create vite@latest
```

---

# Hooks

## UseState

The `useState` hook is used to manage the state values of components. Any change in this value, will trigger a re-rendering of the the component.


### Code

```ts
import {useState} from 'react';

const Compo = () => {
    const [count, setCount] = useState(0);

    const handle = (e) => {
        const value = e.target.value;
        setCount(count => value);
    }

    return <button onClick={handle}>Click: {count}</button>
}

```

### Usage

- Update the value of a UI component without refreshing the page.

## UseRef

`useRef` is a hook used to work with values of an element on the page without the need for re-rendering it.

### Code

```ts
import { useRef } from 'react';

const Compo = () => {
    const countVal = useRef(0);

    const handle = () {
        countVal++;
    }
    
    return <button onClick={handle}>Click</button>
}

export default Compo;
```

### Notes

- `useRef` doesn't trigger a new re-render the component
- `useRef` allows you to update and read values instantly unlike `useState` which waits for the handler function to complete and then trigger the re render
- Use `useState`

### Usage

- Store references to HTML elements so as to take some actions after mount. For example, automatically, activate cursor to a search bar when visiting a page.
- Update values which may not affect anythin on the UI but has an affect on the working of somethine else dependent on its value.

##  UseEffect

Sometimes when a state changes, we would like something on the UI to be changed or updated as a result.
The `useEffect` is used to perform side effects in our application.

The first argument in `useEffect` is a **function** which we would like to run.

The second argument is an **array of dependencies** which tells `useEffect` what states it should be listening to.

The third part of `useEffect` is that we can return a **function** which is a clean up function which runs everytime some dependent state changes.

### Code
```ts
useEffect((
    console.log() => {`The count is ${countVal}.`}, [countVal])
```

### Notes

- The `useEffect` hook will always run once when the component is mounted.


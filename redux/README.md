# Redux

Thank You [Cosden Solutions](https://www.youtube.com/watch?v=5yEG6GhoJBs) 💚

*What is Redux?*

**Redux** is a state management library that allows you to have global state in context of React.
Redux has three main components: Store, Actions, and Reducers

## Store

- The store is essentially the state.
- It is the global state that will be accessible no matter where they are in the React application.
- It can be defined in any way we want with Redux.
- The global store in Redux is divided into multiple slices and they altogether form a single global state which will be accessible to the entire application

## Actions

- Actions are used to tell Redux what it should do to the state
- Actions have two important properties: `type` and `payload`. For example,

```typescript
const incrementAction = {type: 'INCREMENT', payload: 1};
```

## Reducers

- Reducers are responsible for receiving an action and updating the redux store given the type of the action.
- However, Reducers NEVER make changes directly to the redux store.
- Instead, reducers make a copy of the state updates the copy and then replaces the global state.


## Code

Study the below snippets of code to understand redux properly.

### Index

```typescript
// /src/index.tsx
imprt ReactDOM from "react-dom/client";
import App from "./components/app.tsx";
import '../styles/globals.css';
import { Provider } from "react-redux";
import { store } from "./state/store.ts";

ReactDOM.createRoot(document.getElementById("root")!).render(
    <Provider store = {store}>
       <App />
    </Provider>
);
```

### Slice

```typescript
// /src/state/temp/tempSlice.ts
import {createSlice, PayloadAction} from "@reduxjs/toolkit";

interface tempState{
    value: number;
}

const initalState: tempState = {
    value: 0,
};

const tempSlice = createSlice({
    name: "temp",
    initialState,
    reducers: {
        increment: (state) => { // second parameter action is optional
            state.value += 1
        },
        decrement: (state) => {
            state.value -= 1;
        },
        incrementByAmount: (state, action: PayloadAction<number>) => {
            state.value += action.payload;
        }
    },
    extraReducers: (builder) => {
        builder
        .addCase(incrementAsync.fulfilled, (state, action: PayloadAction<number>) => {
            state.value += action.payload;
        })
        .addCase(incrementAsync.pending, () => {
            console.log('Increment Async Pending')
        })
    }
});

export const incrementAsync = createAsyncThunk(
    "temp/incrementAsync", // this names needs to be defined for asynchronous actions
    async (amount: number) => {
        await new Promise((resolve) => setTimeout(resolve, 1000));
        return amount;
    }
);

export const { increment, decrement } = tempSlice.actions;
export default tempSlice.reducer;
```


### Store

```typescript
// /src/state/store.ts
import {configureStore} from "@reduxjs/toolkit";
import tempReducer from "./temp/tempSlice";

export const store = configureStore({
    reducer: {
        temp: tempReducer,
    },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
```

### Component

```jsx
// /src/components/temp.tsx;
import { useDispatch, useSelector } from "react-redux";
import { RootState, AppDispatch } from "../state/store";
import { increment, decrement, incrementByAmount } from "../state/temp/tempSlice";

const Temp = () => {
    const temp = useSelector((state: RootState) => state.counter.value);
    const dispatch = useDispatch<AppDispatch>();
    return (
        <div>
            <button onClick={() => dispatch(increment)}>Increment</button>
            <button onClick={() => dispatch(decrement)}>Decrement</button>
            <button onClick={() => dispatch(incrementByAmount(10))}>Increment</button>
            <button onClick={() => dispatch(incrementAyncThunk(10))}>Increment</button>
        </div>;
    )
}

export default Temp;
```

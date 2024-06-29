

> [!Info]
> The Work of a state its to maintain a value o set of value between rerenders of the component he is on


## useState

```js
const [name, setName] = useState("");
const [state, setState] = useState(() => value);
```


### Example

```js
function NameList() {
    const [list, setList] = useState(["Alice", "Bob", "Charlie"]);
    const [name, setName] = useState("");

    const onAddName = () => {
        list.push(name);
    };

    return (
        <div>
            <ul>
                {list.map((name) => (
                    <li key={name}>{name}</li>
                ))}
            </ul>
            <input value={name} onChange={(e) => setName(e.target.value)} />
            <button onClick={onAddName}>Add Name</button>
        </div>
    );
}
```

- you cant change `name` using `name = "jose"` because `useState` is passing you a deep copy that you're holding in `const [name]` 

- but YOU CAN mutate list "in place" because your passing to `useState` an array `["Alice", "Bob", "Charlie"]` and arrays and objects are passed by reference so `useState` is maintaining a reference and passing you back this reference

> [!Info]
> When you input a name this causes a rerender but when you press the button you call `onAddName` function an putting the `name` into the list but NOT causing a rerender


using 
```js
const onAddName = () => {
    list.push(name);
    setList(list);
};
```
wont cause a rerender because when a useState set function its called react compare the new value with the old value with `Object.is`, if they are the same nothing changed



## [useReducer](https://react.dev/reference/react/useReducer)

```js
// javascript reducer function
const numbers = [10, 20, 30];
const sol = numbers.reduce((cv, n) => cv + n, 0);
```


```js
const [state, dispatch] = useReducer(reducer, initialArg, init?)
```


### Example

```js
import { useReducer } from "react";

function reducer(state, action) {
    switch (action.type) {
        case "SET_NAME":
            return { ...state, name: action.payload };
    }
}

const INITIAL = {
    names: [],
    name: "",
};

function UseReducer() {
    const [state, dispatch] = useReducer(reducer, INITIAL);

    return (
        <div>
            <input
                type="text"
                value={state.name}
                onChange={(e) =>
                    dispatch({ type: "SET_NAME", payload: e.target.value })
                }
            />
            <div>Name = {state.name}</div>
        </div>
    );
}

export default UseReducer;
```


if we instead of returning a new object in the reducer function we do this

```js
function reducer(state, action) {
    switch (action.type) {
        case "SET_NAME":
	        state.name = action.payload;
	        return state;
    }
}
```

what happens its that react don't know that something has changed because react compare the **reference** coming up from the `useReducer` not the actual values inside of the state



### COOL SIMPLIFICATION

```js
import { useReducer } from "react";

const INITIAL = {
    first: "",
    last: "",
};

function UseReducerCool() {
    const [state, dispatch] = useReducer(
        (state, action) => ({ ...state, ...action }),
        INITIAL
    );

    return (
        <div>
            <input
                type="text"
                value={state.first}
                onChange={(e) => dispatch({ first: e.target.value })}
            />
            <input
                type="text"
                value={state.last}
                onChange={(e) => dispatch({ last: e.target.value })}
            />
        </div>
    );
}

export default UseReducerCool;

```


## [useMemo](https://react.dev/reference/react/useMemo)

> [!Info] Why
>  Skipping re-computing of functions

`useMemo`  caches the _result_ of calling your function

```js
const cachedFnResult = useMemo(() => fn(), dependencies);

const cachedValue = useMemo(calculateValue, dependencies)
```





## [useCallback](https://react.dev/reference/react/useCallback)

> [!Info] Why
> Skipping re-rendering of components (specifically functions)
> 

> [!Faq] Caveats
> React **will not throw away the cached function unless there is a specific reason to do that**


`useCallback` is a React Hook that lets you cache a function definition between re-renders.

```js
const cachedFn = useCallback(fn, dependencies)
```

Returns
On the initial render, `useCallback` returns the `fn` function you have passed.

During subsequent renders, it will either return an already stored `fn` function from the last render (if the dependencies haven’t changed), or return the `fn` function you have passed during this render.

> [!When]
> - You pass it as a prop to a component wrapped in [`memo`.](https://react.dev/reference/react/memo) You want to skip re-rendering if the value hasn’t changed. Memoization lets your component re-render only if dependencies changed.
> - The function you’re passing is later used as a dependency of some Hook. For example, another function wrapped in `useCallback` depends on it, or you depend on this function from [`useEffect.`](https://react.dev/reference/react/useEffect)

### Example

You have this code 

```js
function ProductPage({ productId, referrer, theme }) {
  // ...
  return (
    <div className={theme}>
      <ShippingForm onSubmit={handleSubmit} />
    </div>
  );
```


and ShippingForm wrapped in a `memo`
(memo is for cache a component and avoid rerenders if the props does NOT change)
```js
import { memo } from 'react';

const ShippingForm = memo(function ShippingForm({ onSubmit }) {
  // ...
});
```

but the `handleSubmit` function that is passed as props isn't cached with `useCallback`  and since in JavaScript every time a function is created is stored in a different location (its like a different function) the props for the child component that is cached with `memo` changes 

the solution it's to use `useCallBack` this will cause `handleSubmit` be memoize and let to the `ShippingForm` correctly cached with `memo`

### Updating state from a memoized callback [](https://react.dev/reference/react/useCallback#updating-state-from-a-memoized-callback "Link for Updating state from a memoized callback")

This `handleAddTodo` function specifies `todos` as a dependency because it computes the next todos from it:

```js
function TodoList() {
  const [todos, setTodos] = useState([]);

  const handleAddTodo = useCallback((text) => {
    const newTodo = { id: nextId++, text };
    setTodos([...todos, newTodo]);
  }, [todos]);
```

> You’ll usually want memoized functions to have as few dependencies as possible

When you read some state only to calculate the next state, you can remove that dependency by passing an [updater function](https://react.dev/reference/react/useState#updating-state-based-on-the-previous-state) instead:

```js
function TodoList() {
  const [todos, setTodos] = useState([]);

  const handleAddTodo = useCallback((text) => {
    const newTodo = { id: nextId++, text };
    setTodos(todos => [...todos, newTodo]);
  }, []); // ✅ No need for the todos dependency7
```

Here, instead of making `todos` a dependency and reading it inside, you pass an instruction about _how_ to update the state (`todos => [...todos, newTodo]`) to React





## useEffect

```js
useEffect(fn, deps)
```


### Make a time interval

```jsx
const StopWatch = () => {
    const [time, setTime] = useState(0);

    useEffect(() => {
        setInterval(() => 
	        setTime(time + 1), 1000);
    }, []);

    return <div>Time: {time}</div>;
}
```

This has some bugs
1. infinite loop error
		when the component first render the `setInterval` function is invoked and it set and interval and uses `setTime` to increase time by one but this change causes a rerender and another `setInterval` is invoked
2. the time does not change (JS CLOUSURE THING)
		inside the useEffect its the `setInterval` that has a callback function that increases the `time` variable but what happens its that its using a `time` that does not change over time its static inside the closure 

Fixes
1. use a callback in `setTime` 
```js
setInterval(() => setTime(t => t + 1), 1000);
```

2. clean up the `useEffect` when the component is unmount
```js
useEffect(() => {
    const interval = setInterval(() => setTime((t) => t + 1), 1000);
    return () => clearInterval(interval);
}, []);
```



## useRef

`useRef` is a React Hook that lets you reference a value that’s not needed for rendering.

> [!Info]
> you should use useState for input fields when you need to re-render the component when the state changes, and useRef when you don’t need to re-render the component when the state changes


> [!Faq] Caveats
> - You can mutate the `ref.current` property. Unlike state, it is mutable. However, if it holds an object that is used for rendering (for example, a piece of your state), then you shouldn’t mutate that object.
> - When you change the `ref.current` property, React does not re-render your component. React is not aware of when you change it because a ref is a plain JavaScript object.
> - Do not write _or read_ `ref.current` during rendering, except for [initialization.](https://react.dev/reference/react/useRef#avoiding-recreating-the-ref-contents) This makes your component’s behavior unpredictable.
> - In Strict Mode, React will **call your component function twice** in order to [help you find accidental impurities.](https://react.dev/reference/react/useRef#my-initializer-or-updater-function-runs-twice) This is development-only behavior and does not affect production. Each ref object will be created twice, but one of the versions will be discarded. If your component function is pure (as it should be), this should not affect the behavior.

Get the `input` field focus on first render

```js
const ref = useRef(initialValue)
```


```js
import { useEffect, useRef } from "react";

function UseRef() {
    const inputRef = useRef(null);

    useEffect(() => {
        inputRef.current.focus();
    }, []);

    return (
        <div>
            <input type="text" ref={inputRef} />
        </div>
    );
}

export default UseRef;
```



### stopwatch

This example uses a combination of state and refs. Both `startTime` and `now` are state variables because they are used for rendering. But we also need to hold an [interval ID](https://developer.mozilla.org/en-US/docs/Web/API/setInterval) so that we can stop the interval on button press. Since the interval ID is not used for rendering, it’s appropriate to keep it in a ref, and manually update it.

```jsx
import { useState, useRef } from 'react';

export default function Stopwatch() {
  const [startTime, setStartTime] = useState(null);
  const [now, setNow] = useState(null);
  const intervalRef = useRef(null);

  function handleStart() {
    setStartTime(Date.now());
    setNow(Date.now());

    clearInterval(intervalRef.current);
    intervalRef.current = setInterval(() => {
      setNow(Date.now());
    }, 10);
  }

  function handleStop() {
    clearInterval(intervalRef.current);
  }

  let secondsPassed = 0;
  if (startTime != null && now != null) {
    secondsPassed = (now - startTime) / 1000;
  }

  return (
    <>
      <h1>Time passed: {secondsPassed.toFixed(3)}</h1>
      <button onClick={handleStart}>
        Start
      </button>
      <button onClick={handleStop}>
        Stop
      </button>
    </>
  );
}
```


### cancel fetch request when component is unmount

1. first you create the ref
2. you perform the fetch when the ref is flag to the component is mounted
3. when component is unmounted (return of useEffect) clean up the ref

```tsx
import { useEffect, useRef, useState } from "react";

type Quote = {
    quote: string;
    author: string;
};

interface State {
    data: Quote;
    loading: boolean;
    error: string;
}

const useFetch = (counter: number) => {
    const isMounted = useRef(true);
    const url = "https://api.breakingbadquotes.xyz/v1/quotes";
    const [state, setState] = useState<State>({
        data: {} as Quote,
        loading: true,
        error: "",
    });

    useEffect(() => {
        setState({ data: {} as Quote, loading: true, error: "" });
        fetch(url)
            .then((res) => res.json())
            .then((data) =>
                setTimeout(() => {
                    if (isMounted)
                        setState((prev) => ({
                            ...prev,
                            data: data[0],
                            loading: false,
                        }));
                }, 3000)
            )
            .catch((error: Error) =>
                setState((prev) => ({
                    ...prev,
                    error: error.message,
                    loading: false,
                }))
            );

        return () => (isMounted.current = false);
    }, [counter]);

    return { ...state };
};

export default useFetch;
```



### **Do not write _or read_ `ref.current` during rendering.**

React expects that the body of your component [behaves like a pure function](https://react.dev/learn/keeping-components-pure):

- If the inputs ([props](https://react.dev/learn/passing-props-to-a-component), [state](https://react.dev/learn/state-a-components-memory), and [context](https://react.dev/learn/passing-data-deeply-with-context)) are the same, it should return exactly the same JSX.
- Calling it in a different order or with different arguments should not affect the results of other calls.

Reading or writing a ref **during rendering** breaks these expectations.

```jsx
function MyComponent() {
  // ...
  // 🚩 Don't write a ref during rendering
  myRef.current = 123;
  // ...
  // 🚩 Don't read a ref during rendering
  return <h1>{myOtherRef.current}</h1>;
}
```

You can read or write refs **from event handlers or effects instead**.

```jsx
function MyComponent() {
  // ...
  useEffect(() => {
    // ✅ You can read or write refs in effects
    myRef.current = 123;
  });
  // ...
  function handleClick() {
    // ✅ You can read or write refs in event handlers
    doSomething(myOtherRef.current);
  }
  // ...
}
```

If you _have to_ read [or write](https://react.dev/reference/react/useState#storing-information-from-previous-renders) something during rendering, [use state](https://react.dev/reference/react/useState) instead.

### Manipulating the DOM with a ref [](https://react.dev/reference/react/useRef#manipulating-the-dom-with-a-ref "Link for Manipulating the DOM with a ref")

It’s particularly common to use a ref to manipulate the [DOM.](https://developer.mozilla.org/en-US/docs/Web/API/HTML_DOM_API) React has built-in support for this.

1. First, declare a ref object with an initial value of `null`:

```jsx
const inputRef = useRef(null);
```

2. Then pass your ref object as the `ref` attribute to the JSX of the DOM node you want to manipulate:

```jsx
return <input ref={inputRef} />;
```

After React creates the DOM node and puts it on the screen, React will set the `current` property of your ref object to that DOM node. Now you can access the `<input>`’s DOM node and call methods like [`focus()`](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/focus):

```jsx
function handleClick() {
    inputRef.current.focus();
}
```

React will set the `current` property back to `null` when the node is removed from the screen.

### Scrolling an image into view

In this example, clicking the button will scroll an image into view. It uses a ref to the list DOM node, and then calls DOM [`querySelectorAll`](https://developer.mozilla.org/en-US/docs/Web/API/Document/querySelectorAll) API to find the image we want to scroll to.

```jsx
import { useRef } from 'react';

export default function CatFriends() {
  const listRef = useRef(null);

  function scrollToIndex(index) {
    const listNode = listRef.current;
    // This line assumes a particular DOM structure:
    const imgNode = listNode.querySelectorAll('li > img')[index];
    imgNode.scrollIntoView({
      behavior: 'smooth',
      block: 'nearest',
      inline: 'center'
    });
  }

  return (
    <>
      <nav>
        <button onClick={() => scrollToIndex(0)}>
          Tom
        </button>
        <button onClick={() => scrollToIndex(1)}>
          Maru
        </button>
        <button onClick={() => scrollToIndex(2)}>
          Jellylorum
        </button>
      </nav>
      <div>
        <ul ref={listRef}>
          <li>
            <img
              src="https://placekitten.com/g/200/200"
              alt="Tom"
            />
          </li>
          <li>
            <img
              src="https://placekitten.com/g/300/200"
              alt="Maru"
            />
          </li>
          <li>
            <img
              src="https://placekitten.com/g/250/200"
              alt="Jellylorum"
            />
          </li>
        </ul>
      </div>
    </>
  );
}
```




### Uncontrolled Input

Most efficient way to manage an input

```jsx
import { useEffect, useRef, useState } from "react";

function UseRef() {
    const inputRef = useRef(null);
    const [names, setNames] = useState([]);

    useEffect(() => {
        inputRef.current.focus();
    }, []);

    const onAddName = () => {
        setNames([...names, inputRef.current.value]);
        inputRef.current.value = ""
    };

    return (
        <div>
            <div>
                {names.map((name) => (
                    <div key={name}>{name}</div>
                ))}
            </div>
            <input type="text" ref={inputRef} />
            <button onClick={onAddName}>Add Name</button>
        </div>
    );
}

export default UseRef;
```


### keep track of an id

```jsx
import { useEffect, useRef, useState } from "react";

function UseRef() {
    const idRef = useRef(1);
    const inputRef = useRef(null);

    const [names, setNames] = useState([
        { id: idRef.current++, name: "John" },
        { id: idRef.current++, name: "Jane" },
    ]);

    useEffect(() => {
        inputRef.current.focus();
    }, []);

    const onAddName = () => {
        setNames([
            ...names,
            { id: idRef.current, name: inputRef.current.value },
        ]);
        inputRef.current.value = "";
    };

    return (
        <div>
            <div>
                {names.map((name) => (
                    <div key={name.id}>{name.id} - {name.name}</div>
                ))}
            </div>
            <input type="text" ref={inputRef} />
            <button onClick={onAddName}>Add Name</button>
        </div>
    );
}

export default UseRef;

```

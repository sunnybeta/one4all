# Front End Development

## Rendering

Rendering refers to the unavoidable unit of work done to convert code into HTML elements in the UI.
It can take place on either the client side or the server side.
It can happen ahead of time at build time or at every request during runtime.

There are three types of rendering that takes place:

* Server-Side Rendering
* Static Site Generation
* Client-Side Rendering

### Server-Side Rendering & Static Site Generation

These two are together also known as **pre-rendering** because fetching of data and conversion of code into HTML happens before the data is sent to the server.

In server-side rendering, the HTML is generated on the server. This HTML, any JSON response and the instructions to make the page interactive are sent to the client.
On the client side, a fast non-interactive page is loaded and the JSON and code is used to make the UI components interactive, also known as *hydration*. (The server dumps all the data in the HTML itself so that the JS knows about what information was used to render the page.)

Similarly, in static-site generation, the HTML is generated on the server. This is build at runtime and cached (maybe on a CDN) and reused for each request.

Not all code can be run on a server. Example, objects that call `window`, `localStorage,` `stateful` and `media Queries` because they are on the client and not on the server.


### Pre-Rendering vs Client-Side Rendering

For standard pre-rendering style applications, the client receives some JS along with instruction on how to render the componenets on the UI and is called client-side rendering.

In pre-rendering, the client sees the page only when the entire code has been converted to HTML correctly. The user will see a blank page until the rendering is done.


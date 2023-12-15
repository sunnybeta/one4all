# VueJS

VueJS is a popular front end framework for creating data driven single page applications on the client.


## Single Page Application

### How?

- Instead of requesting each page from the server, Single Page Applications handle everything on the client side.
- The initial request to the website sends back the HTML of the website along with VueJS bundle
- Each time we request a new page, the VueJS framework will use that bundle to produce the requested page. This is known as Client Side Rendering

### Cons

- SPA's have higher first load performance which negatively impacts SEO. However, after the initial load, there is a great increase in user experieence.
- Crawlers will not be able to crawl you page effectivelyt as it is a SPA.

## Why VUE?

- Lighweight
- The update to the virtual DOM is quicker and more efficient
- Vue has special directives which simplifies a lot of the programming logic
- Components can be created which are reusable throughout the application.

## Single File Components

Vue Files operate over a single file component.

An SFC is a component description file which consists of the HTML, CSS and the Javascript in the same file.

```vue
<script setup lang='ts'>
import { ref } from 'vue';
const content = "Hello, World";
</script>

<template>
    <div class='container'>
       <p>{{content}}</p> 
    </div>
</template>

<style>
    .container {
        background: white;
        color: red;
    }
</style>
```

## Getting Started

```bash
npm create vite@latest myProject
cd myProject
npm i
npm run dev
```

Visit https://localhost:5173




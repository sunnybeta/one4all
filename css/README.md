# CSS Cookbook

### Boildrplate

```css
*{
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
}
```

### Prevent Overflow Text On A Single Line

```css
.className{
    overflow: hidden;
    white-space: nowrap;
}
```

### Center

- Define a width and use text-align
```css
.className{
    width: 100px;
    text-align: center;
}
```

- Flexbox

```css
.className{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}
```


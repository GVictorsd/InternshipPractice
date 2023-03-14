# Typescript with React

## creating React App with typescript
```
npx create-react-app <appName> --template typescript
cd <appName>
npm start
```

## Typing props
```
type GreetProps = {
    name: string
    messageCount: number
    isloggedin: boolean
}

export const Greet = (props: GreetProps) => {
    ...
}

# Object typing

```
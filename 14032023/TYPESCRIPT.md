# Typescript

## Executing
```
# creates the filename.js file
tsc filename.ts

# run the created js file using node
node filename.js

# watch
tsc filename --watch
```

## Variables
export {} treates the ts file as a module

```
file: hello.ts

export {}
let message = 'Hello World';
console.log(message);
```
- variables can be declared with `let` and `const`
- `let` doesnt require an initial value and its value can change
- `const` requires an initial value and its value cant change

## Types
```
let isbegginer : boolean = true;
let total : number;
let name : string = 'ab';

# null and undefined
let n : null = null;
let u: undefined = undefined;

let isnew:boolean = null;
let myname : string = undefined;

# Arrays
let list1 : number[] = [1,2,3];
let list2: Array<number> = [1,2,4];

# mixed type arrays

# fixed number of values with same order(tuple)
let person1: [string, number] = ['alice', 5]

```

### enum
give names to a type of set of numeric values
```
enum Color {Red, Green, Blue};
let c : Color = Color.Green;
console.log(c);     // 1(index of green)

enum Color {Red=5, Green, Blue};
let c : Color = Color.Green;
console.log(c);     // 6(index of green)
```

### any type
assign any value to the variable
```
let randomvalue : any = 5;
randomvalue = "string";

# can call any of these without any errors
randomvalue.name;
randomvalue();
randomvalue.toUpperCase();
```

### unknown type
```
let myvar: unknown = 10;

# these give error
myvar.name;
myvar();

# need to typespecify inorder to do so
(myvar as string).toUpperCase();

```

### Example
```
let a;      // a is type any
a = 5;
a = true;   // allowed

let a = 6;  // a is number
a = false;  // error
```

### Multitype variables
```
let multitype: number | boolean;
multitype = 6;
multitype = false;

```

## Functions
```
function add(num1: number, num2: number): number {
    return num1 + num2;
}

# optional parameters
# num2 can be optional, is undefined if not passed
# optional parameters are defined after required params

function add(num1: number, num2?: number): number{...}

# default parameters
function add(num1: number, num2: number = 10){...}

# specifying objects
function fullName(person: {firstName: string, lastname: string}){...}
```

## Interfaces
Used to define objects as types

```
# this is not possible for many object properties
function fullName(person: {firstName: string, lastname: string}){...}


# interface person
interface Person{
    firstName: string;
    lastName?: string;  // optional property
}
function fullname(person: Person){...}
```

## Classes and Access Modifiers

```
class Employee {
    name: string;

    constructor (name: string){
        this.name = name;
    }

    method1(){...}
    method2(){...}
    method3(){...}
}

let emp1 = new Employee('alice');
```
Class based inheritance
```
class Manager extends Employee{

    constructor(name: string){
        super(name);
    }

    method4(){...}
}
```

### Access Modifiers

```
class Employee {
    public name1: string;
    private name2: string;
    protected name3: string;
    ...
```

function add1(num1: number, num2: number): number{
    return num1 + num2;
}

function add2(num1: number, num2?:number): number {
    return num2 ? (num1 + num2) : num1;
}

console.log(add2(5))
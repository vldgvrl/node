
let stack = []

const firstTask = {
    iterationResult: () => {
        return stack
    },

    callPush: (value) => {
        if( stack.length !== 0 && stack[stack.length -1] !== '*') stack.push('*')
        for (let i=0; i < value.length; i++) {
            stack.push(value[i]);
        }
        stack.push('*')
        //stack.push(value)
    },

    callPop: () => {
        stack.pop()

        while (stack[stack.length - 1] !== '*') {
            stack.pop()
        }
        //stack.pop()
    }
}

module.exports = firstTask
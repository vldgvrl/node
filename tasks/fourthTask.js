
let stack = []

const fourthTask = {
    iterationResult: () => {
        return stack
    },

    callPush: (value) => {
        if( stack[stack.length -1] !== '*') stack.push('*')
        for (let i=0; i < value.length; i++) {
            stack.push(value[i]);
        }
        stack.push('*')
        //stack.push(value)
    },

    callPop: () => {

        //Run function only if the list is not empty
        if(stack.length !== 0) {
            stack.pop()

            while (stack[stack.length - 1] !== '*') {
                stack.pop()
            }

            //remove first '*' in the list
            if (stack.length === 1) {
                stack.pop() 
            }

        }
    }
}

module.exports = fourthTask
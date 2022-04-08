let stack = []

const secondTask = {
    fifoImplementation: () => {
        return stack
    },

    callEnqueue: (value) => {
        stack.push(value)
    },

    callDequeue: () => {
        console.log("dequequ called");
        if(stack.length === 0 ) {
            return new Error("Underflow")
        } else {
            console.log(stack.shift());
            //stack.shift()
        } 
    }
}

module.exports = secondTask
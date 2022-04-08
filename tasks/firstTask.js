
let stack = []

const firstTask = {
    lifoImplementation: () => {
        return stack
    },

    callPush: (value) => {
        stack.push(value)
    },

    callPop: () => {
        stack.pop()
    }
}

module.exports = firstTask
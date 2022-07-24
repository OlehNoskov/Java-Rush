function calculateQuest(questsInput) {
    let guests = '';
    for (const i of questsInput) {
        if ('0123456789'.includes(i)) {
            guests += i;
        } else if (guests.length > 0) {
            break;
        }
    }
    return +guests || "not a number";
}

console.log(calculateQuest('020'))
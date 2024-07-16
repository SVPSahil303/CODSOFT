document.getElementById('marksForm').addEventListener('submit', function(event) {
    event.preventDefault();

    let marks = {
        subject1: parseInt(document.getElementById('subject1').value),
        subject2: parseInt(document.getElementById('subject2').value),
        subject3: parseInt(document.getElementById('subject3').value),
        subject4: parseInt(document.getElementById('subject4').value),
        subject5: parseInt(document.getElementById('subject5').value)
    };

    fetch('/api/marks/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(marks)
    })
    .then(response => response.json())
    .then(result => {
        let message = `Total Marks: ${result.totalMarks}\nAverage Percentage: ${result.averagePercentage.toFixed(2)}\nGrade: ${result.grade}`;
        displayFancyPrompt(message);
    });
});

function displayFancyPrompt(message) {
    let promptContainer = document.createElement('div');
    promptContainer.className = 'prompt-container';
    let promptBox = document.createElement('div');
    promptBox.className = 'prompt-box';
    let promptMessage = document.createElement('p');
    promptMessage.innerText = message;
    promptBox.appendChild(promptMessage);
    promptContainer.appendChild(promptBox);
    document.body.appendChild(promptContainer);

    setTimeout(() => {
        promptContainer.style.opacity = 1;
    }, 10);

    promptContainer.addEventListener('click', () => {
        promptContainer.style.opacity = 0;
        setTimeout(() => {
            document.body.removeChild(promptContainer);
        }, 300);
    });
}

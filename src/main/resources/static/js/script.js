function showPanel(panelId) {
    var panels = document.querySelectorAll('.panel');
    panels.forEach(panel => panel.style.display = 'none');
    document.getElementById('panel-' + panelId).style.display = 'block';
}

function executeScript() {
    const script = document.getElementById('scriptInput').value;
    fetch('/scripting/script', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: script
    })
        .then(response => response.json())
        .then(data => {
            if (data.satckTrace) { // Check for spelling mistake in your original class, consider correcting it if possible
                document.getElementById('stackTrace').textContent = 'Stack Trace: ' + data.satckTrace;
                showPanel('stack');
            } else {
                document.getElementById('result').textContent = 'Result: ' + data.result;
                document.getElementById('output').textContent = 'Output: ' + data.output;
                showPanel('result');
            }
        })
        .catch(error => {
            document.getElementById('stackTrace').textContent = 'Error: ' + error;
            showPanel('stack');
        });
}

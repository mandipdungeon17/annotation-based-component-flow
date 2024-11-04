// File: /my-web-app/src/app.js

// Import the API module
import { makeAPICall } from './api/api.js';

let currentComponent = '';

document.addEventListener('DOMContentLoaded', () => {
    console.log('DOM fully loaded and parsed');

    // WebSocket connection
    const socket = new WebSocket('ws://localhost:8080/logs');
    const logContainer = document.getElementById('logContainer');

    socket.onopen = function() {
        console.log('WebSocket connection established');
    };

    socket.onmessage = function(event) {
        console.log('Received message:', event.data);
        const logEntries = event.data.split('\n').map(line => JSON.parse(line));
        displayLogs(logEntries);
    };

    socket.onerror = function(error) {
        console.error('WebSocket Error:', error);
    };

    socket.onclose = function() {
        console.log('WebSocket connection closed');
    };

    document.getElementById('submit').addEventListener('click', async () => {
        console.log('Submit button clicked');

        // Clear the logContainer
        logContainer.innerHTML = '';

        const input1 = document.getElementById('input1').value;
        const input2 = document.getElementById('input2').value;
        console.log(`Input1: ${input1}, Input2: ${input2}`);
        
        try {
            const response = await makeAPICall(input1, input2);
            console.log('API response:', response);
            document.getElementById('response').innerText = JSON.stringify(response, null, 2);
        } catch (error) {
            console.error('Error:', error);
            document.getElementById('response').innerText = 'An error occurred while making the API call.';
        }
    });
});

// Function to display logs hierarchically
function displayLogs(logEntries) {
    const logContainer = document.getElementById('logContainer');

    // let currentComponent = '';

    logEntries.forEach(entry => {
        if (entry.component !== currentComponent) {
            // New component
            const componentDiv = document.createElement('div');
            componentDiv.className = 'component';
            componentDiv.textContent = `Component: ${entry.component}`;
            logContainer.appendChild(componentDiv);
            currentComponent = entry.component;
        }

        // New class within the same component
        const classDiv = document.createElement('div');
        classDiv.className = 'class-entry';
        classDiv.innerHTML = `<strong>Class: ${entry.className}</strong>`;
        logContainer.appendChild(classDiv);

        // Method details within the class
        const logDiv = document.createElement('div');
        logDiv.className = 'log-entry';
        logDiv.innerHTML = `
            <div><strong>Method:</strong> ${entry.method}</div>
            <div><strong>Input Values:</strong> ${JSON.stringify(entry.inputValues)}</div>
            <div><strong>Timestamp:</strong> ${entry.timestamp}</div>
        `;
        logContainer.appendChild(logDiv);
    });
}

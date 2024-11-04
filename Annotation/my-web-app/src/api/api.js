// api.js

// Function to make the API call to the backend
async function callBackendAPI(endpoint, params) {
  const url = new URL(endpoint, 'http://localhost:8080'); // Adjust the base URL as needed
  Object.keys(params).forEach(key => url.searchParams.append(key, params[key]));

  try {
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });
    if (!response.ok) {
      throw new Error('API request failed');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error:', error);
    throw error;
  }
}

// Function to call service1Method1
async function makeAPICall(input1, input2) {
  const endpoint = '/service1/method1';
  const params = { input1, input2 };
  return await callBackendAPI(endpoint, params);
}

export { makeAPICall };
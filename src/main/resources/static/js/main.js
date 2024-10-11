// Handle form submissions and API calls

// Post Ride API Call
document.getElementById('postRideForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const rideData = {
        origin: document.getElementById('origin').value,
        destination: document.getElementById('destination').value,
        availableSeats: document.getElementById('availableSeats').value,
        departureTime: document.getElementById('departureTime').value
    };

    fetch('http://localhost:8080/rides/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(rideData)
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('responseMessage').innerText = 'Ride posted successfully!';
    })
    .catch(error => {
        console.error('Error:', error);
    });
});


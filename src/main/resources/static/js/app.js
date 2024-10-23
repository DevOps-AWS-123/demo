function animateButton() {
    const button = document.querySelector('.animate-btn');
    button.classList.add('animate');

    // Operation: Change the message on button click
    const heading = document.querySelector('.heading');
    heading.textContent = "Button Clicked! Performing Action...";

    // Simulate a time-consuming operation
    setTimeout(() => {
        heading.textContent = "Welcome to the Web Application!";
    }, 2000); // Change back after 2 seconds

    // Remove the animation class after the animation ends
    setTimeout(() => {
        button.classList.remove('animate');
    }, 500); // Animation duration in milliseconds
}

// Optional: Define a CSS class for the button animation
document.addEventListener("DOMContentLoaded", function() {
    const buttonStyle = document.createElement('style');
    buttonStyle.innerHTML = `
        .animate {
            transform: scale(1.1);
            transition: transform 0.5s;
        }
    `;
    document.head.appendChild(buttonStyle);
});

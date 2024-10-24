CREATE TABLE weather_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100),
    temperature DOUBLE,
    humidity INT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

#include "DHT.h"
#include <arduino-timer.h>

#define DHTPIN 16
#define DHTTYPE DHT11
#define NR_ATMOSPHERIC_TEMPERATURE_SENSORS 4 // Sensor ID: 7, Sensor ID: 8, Sensor ID: 9, Sensor ID: 10
#define NR_ATMOSPHERIC_HUMIDITY_SENSORS 4 // Sensor ID: 3, Sensor, ID: 4, Sensor ID: 5, Sensor 6
#define DATA_LENGTH 100
#define TYPE_NAME_LENGTH 30
#define UNIT_NAME_LENGTH 30
#define TEMPERATURE_HUMIDITY_PERIOD 60000 // 1 minute in milliseconds

char sensor_types[][TYPE_NAME_LENGTH] =
{
  "atmospheric_temperature",
  "atmospheric_humidity"
};
enum sensor_type {
  ATMOSPHERIC_TEMPERATURE = 0,
  ATMOSPHERIC_HUMIDITY
};
char sensor_units[][UNIT_NAME_LENGTH] =
{
  "celsius",
  "percentage"
};
enum sensor_unit {
  CELSIUS = 0,
  PERCENTAGE
};
DHT dht(DHTPIN, DHTTYPE);
auto timer = timer_create_default(); // create a timer with default settings

bool read_atmospheric_temperature_humidity(void *) {
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  if (!isnan(temperature) && !isnan(humidity)) {
    unsigned long currentMinute = millis() / 60000; // calculate the current minute
    char buffer[DATA_LENGTH];

    snprintf(buffer, DATA_LENGTH - 1,
             "minute %d:\n"
             "temperature: %.2f\n"
             "humidity: %.2f",
             currentMinute, temperature, humidity);
    Serial.println(buffer);
  }

  return true;
}

void setup() {
  Serial.begin(9600);
  dht.begin();
  timer.every(TEMPERATURE_HUMIDITY_PERIOD, read_atmospheric_temperature_humidity);
}

void loop() {
  timer.tick(); // tick the timer
}

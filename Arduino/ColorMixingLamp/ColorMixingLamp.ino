const int gLEDPin = 9;
const int rLEDPin = 11;
const int bLEDPin = 10;
const int rInPin = A2;
const int gInPin = A0;
const int bInPin = A1;

int rVal = 0;
int gVal = 100;
int bVal = 0;
int rInVal = 0;
int gInVal = 0;
int bInVal = 0;

bool rUp = false;
bool gUp = false;
bool bUp = false;

void setup() {
  Serial.begin(9600);

  pinMode(gLEDPin, OUTPUT);
  pinMode(rLEDPin, OUTPUT);
  pinMode(bLEDPin, OUTPUT);
}

void loop() {
//  rInVal = analogRead(rInPin);
//  delay(5);
//  gInVal = analogRead(gInPin);
//  delay(5);
//  bInVal = analogRead(bInPin);
//  Serial.print("Raw Sensor Values \t red: ");
//  Serial.print(rInVal);
//  Serial.print("\t green: ");
//  Serial.print(gInVal);
//  Serial.print("\t blue: ");
//  Serial.println(bInVal);
//  rVal = rInVal/4;
//  gVal = gInVal/4;
//  bVal = bInVal/4;
  if(bVal == 100){
    rUp = true;
    bUp = false;
  }
  if(rVal == 100){
    gUp = true;
    rUp = false;
  }
  if(gVal == 100){
    bUp = true;
    gUp = false;
  }

  if(rUp){
    rVal += 5;
  }else if(rVal > 0){
    rVal -= 5;
  }
  if(gUp){
    gVal += 5;
  }else if(gVal > 0){
    gVal -= 5;
  }
  if(bUp){
    bVal += 5;
  }else if(bVal > 0){
    bVal -= 5;
  }
  
  Serial.print("rVal: ");
  Serial.print(rVal);
  Serial.print(" gVal: ");
  Serial.print(gVal);
  Serial.print(" bVal: ");
  Serial.println(bVal);
  
//  Serial.print("Mapped Sensor Values \t red: ");
//  Serial.print(rVal);
//  Serial.print("\t green: ");
//  Serial.print(gVal);
//  Serial.print("\t blue: ");
//  Serial.println(bVal);
//  analogWrite(rLEDPin, rVal);
//  analogWrite(gLEDPin, gVal);
//  analogWrite(bLEDPin, bVal);

  analogWrite(rLEDPin, rVal);
  analogWrite(gLEDPin, gVal);
  analogWrite(bLEDPin, bVal);
}

ATM project // Swing app

Intro
--
Swing app ATM consists of:
1. Registration
2. Login
3. User interface with functional buttons
  - Sending cash
  - Receiving cash
  - Show transaction history
  - Save transactions to file


Main goal
--
Main goal was to connect more classes using **static**, **inheritance** with progressive opening and closing different app windows (preventing opening loginform sooner than registrationform etc.). Each frame is followed up by another using methods.

Registration form
--
The root frame. Setting up the card no, user and pin. Preventing pin from nan values.

Login form
--
Fill in data from registration like pin and fullname.

Overview
--
Whole overview of atm with all functions.

Sending money
--
Addressee + amount of cash (preventing send more cash than you have).

Receive money
--
Sender + amount of cash.

Transaction history
--
Extract all completed transactions into the console.

Save to file
--
Save transaction history to text file.

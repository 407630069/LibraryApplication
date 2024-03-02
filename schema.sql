CREATE TABLE User (
    UserId int NOT NULL PRIMARY KEY,
    PhoneNumber varchar(20) NOT NULL UNIQUE,
    Password varchar(255) NOT NULL,
    UserName varchar(50) NOT NULL,
    RegistrationTime datetime NOT NULL,
    LastLoginTime datetime
);

CREATE TABLE Inventory (
    InventoryId int NOT NULL PRIMARY KEY,
    ISBN varchar(13) NOT NULL,
    StoreTime datetime NOT NULL,
    Status varchar(10) NOT NULL
);

CREATE TABLE Book (
    ISBN varchar(13) NOT NULL PRIMARY KEY,
    Name varchar(255) NOT NULL,
    Author varchar(100) NOT NULL,
    Introduction text
);


CREATE TABLE BorrowingRecord (
    UserId int NOT NULL,
    InventoryId int NOT NULL,
    BorrowingTime datetime NOT NULL,
    ReturnTime datetime,
    CONSTRAINT FK_UserId FOREIGN KEY (UserId) REFERENCES User (UserId),
    CONSTRAINT FK_InventoryId FOREIGN KEY (InventoryId) REFERENCES Inventory (InventoryId)
);
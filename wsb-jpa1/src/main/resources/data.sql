-- Tabela Address
INSERT INTO address (id, city, address_line1, address_line2, postal_code)
VALUES (1, 'New York', 'Main Street', 'Apt 1', '10001'),
       (2, 'Los Angeles', 'Second Avenue', 'Suite 5', '90001');

-- Tabela Patient
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES (1, 'John', 'Doe', '123456789', 'john.doe@example.com', 'P001', '1980-01-15', 1),
       (2, 'Jane', 'Smith', '987654321', 'jane.smith@example.com', 'P002', '1990-05-20', 2);

-- Tabela Doctor
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 'Alice', 'Brown', '555123123', 'alice.brown@example.com', 'D001', 'CARDIOLOGY'),
       (2, 'Bob', 'Green', '555987987', 'bob.green@example.com', 'D002', 'DERMATOLOGY');

-- Tabela Visit
INSERT INTO visit (id, description, time, patient_id, doctor_id)
VALUES (1, 'Routine checkup', '2024-12-08 10:00:00', 1, 1),
       (2, 'Dermatology consultation', '2024-12-09 14:30:00', 2, 2);

-- Tabela MedicalTreatment
INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Blood Test', 'LABORATORY', 1),
       (2, 'Skin Analysis', 'DIAGNOSTIC', 2);
-- Insert sample tasks for demonstration
INSERT INTO task (title, description, due_date, status, created_at, updated_at) 
VALUES ('Setup Project Environment', 'Initialize Spring Boot project and dependencies', CURRENT_DATE, 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO task (title, description, due_date, status, created_at, updated_at) 
VALUES ('Implement Security', 'Add Basic Auth and H2 console access', CURRENT_DATE, 'IN_PROGRESS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO task (title, description, due_date, status, created_at, updated_at) 
VALUES ('Write Unit Tests', 'Test critical service layer functions', DATEADD('DAY', 2, CURRENT_DATE), 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO task (title, description, due_date, status, created_at, updated_at) 
VALUES ('Submit Case Study', 'Push code to GitHub and email the recruiter', '2026-05-15', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
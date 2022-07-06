create table taskAssignment
(
    id SERIAL PRIMARY KEY,
    transactionCode varchar(10) not null,
    moduleName varchar(50) not null,
    taskName varchar(50) not null,
    taskDescription varchar(50) not null,
    linkUrl varchar(50) not null,
    assignmentType varchar(10) not null,
    assignTo varchar(20) not null,
    taskStatus varchar(10) not null,
    created_at timestamp not null,
    updated_at timestamp
);

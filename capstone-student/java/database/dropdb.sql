-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'capstone_student';

DROP DATABASE capstone_student;

DROP USER capstone_student_owner;
DROP USER capstone_student_appuser;

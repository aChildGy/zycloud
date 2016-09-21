@echo off
rem /**
rem  */
echo.
echo warning !!!warning !!!warning !!!warning !!! init data ? 
echo.
pause
echo.
echo warning !!!warning !!!warning !!!warning !!! init data ? 
pause
echo.

cd %~dp0

call mvn antrun:run -Pinit-db

cd .
pause

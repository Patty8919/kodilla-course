call runcrud.bat
if "%ERRORLEVEL%" == "0" goto gettasks
echo.
echo RUNCRUD.BAT has errors - breaking work
goto fail

:gettasks
start chrome "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto stopgettasks
echo Cannot open file
goto fail

:stopgettasks
call %CATALINA_HOME%\bin\shutdown.bat

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
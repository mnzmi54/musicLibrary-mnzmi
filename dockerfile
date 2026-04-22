FROM tomcat:9.0

COPY dist/MusicLibrary.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]

FROM nuxeo:8.10

WORKDIR /tmp 
ADD nuxeo-ipv-core/target/nuxeo-ipv-core-1.0-SNAPSHOT.jar /tmp/nuxeo-ipv-core-1.0-SNAPSHOT.jar
ADD nuxeo-ipv-rest/target/nuxeo-ipv-rest-1.0-SNAPSHOT.jar /tmp/nuxeo-ipv-rest-1.0-SNAPSHOT.jar


RUN /bin/echo 5d500f0b-4e8e-4f8c-8c04-b06571e9f9a9 > $NUXEO_HOME/nxserver/data/instance.clid
RUN /bin/echo b325d6e1-7a9b-4c53-a27b-6c5899972d75 >> $NUXEO_HOME/nxserver/data/instance.clid

RUN cp /tmp/nuxeo-ipv-core-1.0-SNAPSHOT.jar $NUXEO_HOME/nxserver/bundles/
RUN cp /tmp/nuxeo-ipv-rest-1.0-SNAPSHOT.jar $NUXEO_HOME/nxserver/bundles/
RUN $NUXEO_HOME/bin/nuxeoctl mp-install amazon-s3-online-storage
RUN $NUXEO_HOME/bin/nuxeoctl mp-install nuxeo-dam nuxeo-jsf-ui nuxeo-web-ui 
RUN rm -rf $NUXEO_HOME/data/* 
RUN rm $NUXEO_HOME/nxserver/data/instance.clid

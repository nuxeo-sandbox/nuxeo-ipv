## Principles & Concepts


## How it works

## Pre requisites
IPV is a cloud web appliaction. 

## Build
`cd nuxeo-ipv && mvn clean install`

## Deploy (how to install build product)

Required packages.:

- `nuxeo-dam`
- `amazon-s3-online-storage`
- `nuxeo-jsf-ui`
- `nuxeo-web-ui`

1. `cp nuxeo-ipv-core/target/nuxeo-ipv-core-1.0-SNAPSHOT.jar nuxeo-ipv-rest/target/nuxeo-ipv-rest-1.0-SNAPSHOT.jar NUXEO_HOME/nxserver/bundles `
2. For callback make sure your nuxeo instance is available to the internet (setup your internet firewall on your modem if pointing to your local) and add this URL to IPV `http://<yourIP>:<port>/nuxeo/site/ipv/callback` in your account callbacks
3. Check that the firewall allows only incoming connection from IPV IP on the callback URL `/nuxeo/site/ipv/callback`
4. Edit `nuxeo.conf` and set the following properties:

`nuxeo.s3storage.directdownload=true`

`nuxeo.s3storage.region=<YourS3Region>`

`nuxeo.s3storage.bucket=<YourBucketName>`

`nuxeo.s3storage.awsid=<YourAWSID>`

`nuxeo.s3storage.awssecret=<YourAWSsecret>`

`nuxeo.ipv.hostUrl=http://sandbox.aws.ipv.com`

`nuxeo.ipv.process.name=Nuxeo Test`

`nuxeo.ipv.assetUiUrl=/NuxeoLogger/Log/LogMediaAsset?mediaId=`
5. Grant access nuxeo to S3 bucket by adding this [AWS policy](https://doc.nuxeo.com/nxdoc/amazon-s3-online-storage/#aws-configuration) 


# Resources (Documentation and other links)


# Contributing / Reporting issues

Link to JIRA component (or project if there is no component for that project).
Sample: https://jira.nuxeo.com/browse/NXP/component/14503/
Sample: https://jira.nuxeo.com/secure/CreateIssue!default.jspa?project=NXP

# License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)


# About Nuxeo

The [Nuxeo Platform](http://www.nuxeo.com/products/content-management-platform/) is an open source customizable and extensible content management platform for building business applications. It provides the foundation for developing [document management](http://www.nuxeo.com/solutions/document-management/), [digital asset management](http://www.nuxeo.com/solutions/digital-asset-management/), [case management application](http://www.nuxeo.com/solutions/case-management/) and [knowledge management](http://www.nuxeo.com/solutions/advanced-knowledge-base/). You can easily add features using ready-to-use addons or by extending the platform using its extension point system.

The Nuxeo Platform is developed and supported by Nuxeo, with contributions from the community.

Nuxeo dramatically improves how content-based applications are built, managed and deployed, making customers more agile, innovative and successful. Nuxeo provides a next generation, enterprise ready platform for building traditional and cutting-edge content oriented applications. Combining a powerful application development environment with
SaaS-based tools and a modular architecture, the Nuxeo Platform and Products provide clear business value to some of the most recognizable brands including Verizon, Electronic Arts, Sharp, FICO, the U.S. Navy, and Boeing. Nuxeo is headquartered in New York and Paris.
More information is available at [www.nuxeo.com](http://www.nuxeo.com).

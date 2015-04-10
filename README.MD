Java client for Mountebank
==========================

## What is Mountebank?

mountebank is the first tool to provide multi-protocol, multi-language test doubles over the wire.
Just point your application to mountebank instead of the real dependency,
and test like you would with traditional stubs and mocks.

At the moment, the following protocols are supported:
* http
* https
* tcp (text and binary)
* smtp

mountebank supports mock verification, stubbing with advanced predicates, JavaScript injection,
and record-playback through proxying.

[![how it works](https://github.com/bbyars/mountebank/blob/master/src/public/images/overview.gif?raw=true)](https://github.com/bbyars/mountebank/blob/master/src/public/images/overview.gif?raw=true)

See [getting started](http://www.mbtest.org/docs/gettingStarted) guide for more information.

## Info about this client

This library offers an easy way to execute calls to the mountebank tool installed on your machine. In order to use this library, you will need
to install mountebank on your machine by following the instructions bellow. Once you install mountebank, you will need to include this client in your build file,
which will allow you to use it in your project.

Once you've finished this, you can create an imposter by using the ImposterFactory.

In order to create an imposter which returns a response with status code of 400, you can use the following lines of code:

    Imposter imposter = new ImposterFactory().createHttpImposter("4545");
    Map<String, String> newHashMap = new HashMap<String, String>();
    newHashMap.put("Location", "https://location.com");
    imposter.addResponses(newArrayList(new ResponseBuilder().withStatusCode("400").build()));


## Install and Run

[![NPM version](https://badge.fury.io/js/mountebank.png)](http://badge.fury.io/js/mountebank)

Install:

    npm install -g mountebank --production

Run:

    mb

## Learn More

After installing and running, view the docs in your browser at http://localhost:2525, or visit the
[public site](http://www.mbtest.org/).

## Contributing

If I have missed a feature from Mountebank, please feel free to submit a pull request. For any other questions, you can reach me at aserafimoski@gmail.com

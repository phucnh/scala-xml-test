package com.example

import com.iabtechlab._
import scala.xml

object ScalaxbTest extends App {

  val vastXml: xml.Elem = xml.XML.loadString(Data.vastString)
  val deserialized: VAST = scalaxb.fromXML[VAST](vastXml)

  val serialized: xml.NodeSeq = scalaxb.toXML[VAST](deserialized, None, Some("VAST"),
    scalaxb.toScope())

  println(serialized)
}

object Data {
  val vastString = """<?xml version="1.0" encoding="UTF-8"?>
<VAST version="2.0">
  <Ad id="ad-id1">
    <InLine>
      <AdSystem>2.0</AdSystem>
      <AdTitle>12</AdTitle>
      <Impression id="1stParty" />
      <Creatives>
        <Creative>
          <Linear>
            <Duration>00:00:19.08</Duration>
            <TrackingEvents>
              <Tracking event="creativeView">
                <![CDATA[https://example.com/createView]]>
              </Tracking>
              <Tracking event="start"><![CDATA[https://example.com/start]]></Tracking>
              <Tracking event="firstQuartile"><![CDATA[https://example.com/firstQuartile]]></Tracking>
            </TrackingEvents>
            <VideoClicks>
              <ClickThrough id="1"><![CDATA[http://example.com/clickthrough]]></ClickThrough>
            </VideoClicks>
            <MediaFiles>
              <MediaFile width="640" height="360" type="video/mp4" delivery="progressive"><![CDATA[https://example.com/creatives/video.mp4]]></MediaFile>
              <MediaFile width="640" height="360" type="video/webm" delivery="progressive"><![CDATA[https://example.com/creatives/video.webm]]></MediaFile>
            </MediaFiles>
          </Linear>
        </Creative>
      </Creatives>
    </InLine>
  </Ad>
</VAST>
  """
}

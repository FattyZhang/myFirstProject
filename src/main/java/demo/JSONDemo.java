package demo;
import java.util.ArrayList;
/**
 * fastJson的使用
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import model.JSONVo;

public class JSONDemo {
	
	/**
	 *	JSONPath
	 */
	@Test
	public void test() {
	//	String str = "{\"dataElementsMaster\":{\"dataElementsIndiv\":[{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":4,\"reference\":{\"number\":2,\"qualifier\":\"OT\"},\"segmentName\":\"AP\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"7\"},\"longFreetext\":\"13602567717\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":5,\"reference\":{\"number\":25,\"qualifier\":\"OT\"},\"segmentName\":\"TK\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[],\"ticketElement\":{\"ticket\":{\"airlineCode\":\"B6\",\"date\":\"080119\",\"electronicTicketFlag\":\"ET\",\"indicator\":\"OK\",\"officeId\":\"NYCM02100\",\"sitaAddress\":[]}}},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":6,\"reference\":{\"number\":11,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"2\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"B6\",\"freeText\":[\"P/CN/ED2445625/CN/06FEB78/F/23MAY28/HU/HONGMEI\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":7,\"reference\":{\"number\":12,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"B6\",\"freeText\":[\"P/CN/G52891953/CN/07FEB86/F/23MAR23/SHANG/PEI\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":8,\"reference\":{\"number\":16,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"1A\",\"freeText\":[\"PLS TICKET OR CANCEL BY 08JAN19 2359USNY PER GDS\"],\"status\":\" \",\"type\":\"ADTK\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":9,\"reference\":{\"number\":17,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"1A\",\"freeText\":[\"TTL\"],\"status\":\" \",\"type\":\"ADTK\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":10,\"reference\":{\"number\":4,\"qualifier\":\"OT\"},\"segmentName\":\"OS\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"companyId\":\"B6\",\"subjectQualifier\":\"3\",\"type\":\"28\"},\"longFreetext\":\"CTCE SERVICE//MYFAREBOX.COM\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":11,\"reference\":{\"number\":5,\"qualifier\":\"OT\"},\"segmentName\":\"OS\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"companyId\":\"B6\",\"subjectQualifier\":\"3\",\"type\":\"28\"},\"longFreetext\":\"CTCM PAX 13602567717\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"accounting\":{\"account\":{\"number\":\"Y138022588\"}},\"elementManagementData\":{\"lineNumber\":12,\"reference\":{\"number\":20,\"qualifier\":\"OT\"},\"segmentName\":\"AI\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":13,\"reference\":{\"number\":1,\"qualifier\":\"OT\"},\"segmentName\":\"RM\"},\"elementsIndicators\":[],\"extendedRemark\":{\"structuredRemark\":{\"freetext\":\"NOTIFY PASSENGER PRIOR TO TICKET PURCHASE & CHECK-IN: FEDERAL LAWS FORBID THE CARRIAGE OF HAZARDOUS MATERIALS - GGAMAUSHAZ\",\"type\":\"RM\"}},\"miscellaneousRemarks\":{\"individualSecurity\":[],\"remarks\":{\"freetext\":\"NOTIFY PASSENGER PRIOR TO TICKET PURCHASE & CHECK-IN: FEDERAL LAWS FORBID THE CARRIAGE OF HAZARDOUS MATERIALS - GGAMAUSHAZ\",\"type\":\"RM\"}},\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":14,\"reference\":{\"number\":21,\"qualifier\":\"OT\"},\"segmentName\":\"RM\"},\"elementsIndicators\":[],\"extendedRemark\":{\"structuredRemark\":{\"freetext\":\"****CHARGE 108.30 ON PUB FARE\",\"type\":\"RM\"}},\"miscellaneousRemarks\":{\"individualSecurity\":[],\"remarks\":{\"freetext\":\"****CHARGE 108.30 ON PUB FARE\",\"type\":\"RM\"}},\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":15,\"reference\":{\"number\":22,\"qualifier\":\"OT\"},\"segmentName\":\"RM\"},\"elementsIndicators\":[],\"extendedRemark\":{\"structuredRemark\":{\"category\":\"*\",\"freetext\":\"UD25 P\",\"type\":\"RM\"}},\"miscellaneousRemarks\":{\"individualSecurity\":[],\"remarks\":{\"freetext\":\"*UD25 P\",\"type\":\"RM\"}},\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":16,\"reference\":{\"number\":26,\"qualifier\":\"OT\"},\"segmentName\":\"FA\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P06\"},\"longFreetext\":\"PAX 279-7276277303/ETB6/USD108.30/07JAN19/NYCM02100/33643271\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":17,\"reference\":{\"number\":27,\"qualifier\":\"OT\"},\"segmentName\":\"FA\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P06\"},\"longFreetext\":\"PAX 279-7276277304/ETB6/USD108.30/07JAN19/NYCM02100/33643271\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":18,\"reference\":{\"number\":24,\"qualifier\":\"OT\"},\"segmentName\":\"FB\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P07\"},\"longFreetext\":\"PAX 0000000000 TTP/ET/INVJ/RT OK ETICKET - USD216.60\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":19,\"reference\":{\"number\":9,\"qualifier\":\"OT\"},\"segmentName\":\"FE\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"10\"},\"longFreetext\":\"PAX /C1 NONREF - FEE FOR CHG/CXL -BG:B6\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":20,\"reference\":{\"number\":28,\"qualifier\":\"OT\"},\"segmentName\":\"FI\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P16\"},\"longFreetext\":\"PAX 0000000000 INV 0002066324\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":21,\"reference\":{\"number\":23,\"qualifier\":\"OT\"},\"segmentName\":\"FM\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"11\"},\"longFreetext\":\"*M*0\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":22,\"reference\":{\"number\":18,\"qualifier\":\"OT\"},\"segmentName\":\"FP\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"16\"},\"longFreetext\":\"PAX CCCAXXXXXXXXXXXX9578/0220/A928995\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":23,\"reference\":{\"number\":10,\"qualifier\":\"OT\"},\"segmentName\":\"FV\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P18\"},\"longFreetext\":\"PAX B6\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"reference\":{\"number\":0,\"qualifier\":\"OT\"},\"segmentName\":\"ES\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"pnrSecurity\":{\"indicator\":\"G\",\"security\":[{\"accessMode\":\"R\",\"identification\":\"SZXCC221A\"}],\"securityInfo\":{\"agentCode\":\"WSSU\",\"creationDate\":\"080119\",\"officeId\":\"NYCM0210Y\"}},\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]}],\"marker2\":{}},\"freeFormText\":[],\"freetextData\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P12\"},\"longFreetext\":\"--- TST RLR SFP ---\"}],\"generalErrorInfo\":[],\"historyData\":[],\"originDestinationDetails\":[{\"extendedContentGroup\":[],\"itineraryInfo\":[{\"elementManagementItinerary\":{\"lineNumber\":3,\"reference\":{\"number\":1,\"qualifier\":\"ST\"},\"segmentName\":\"AIR\"},\"elementsIndicators\":{\"statusInformation\":{\"indicator\":\"TSA\"}},\"flightDetail\":{\"arrivalStationInfo\":{\"terminal\":\"5\"},\"departureInformation\":{\"departTerminal\":\"5\"},\"facilities\":[{\"entertainement\":\"M\",\"entertainementDescription\":\"S\",\"productExtensionCode\":[]}],\"productDetails\":{\"equipment\":\"32S\",\"numOfStops\":0,\"weekDay\":3}},\"flixInfo\":[],\"generalOption\":[],\"insuranceInformation\":[],\"itineraryMessageAction\":{\"business\":{\"function\":\"1\"}},\"itineraryReservationInfo\":{\"reservation\":{\"companyId\":\"B6\",\"controlNumber\":\"DDWJTZ\"}},\"itineraryfreeFormText\":[],\"legInfo\":[],\"markerRailTour\":{},\"relatedProduct\":{\"quantity\":2,\"status\":[\"HK\"]},\"selectionDetails\":{\"selection\":[{\"option\":\"P2\"}]},\"taxInformation\":[],\"travelProduct\":{\"boardpointDetail\":{\"cityCode\":\"JFK\"},\"companyDetail\":{\"identification\":\"B6\"},\"offpointDetail\":{\"cityCode\":\"LAX\"},\"product\":{\"arrDate\":\"160119\",\"arrTime\":\"1859\",\"depDate\":\"160119\",\"depTime\":\"1520\"},\"productDetails\":{\"classOfService\":\"P\",\"identification\":\"1323\"},\"typeDetail\":{\"detail\":\"ET\"}}}],\"originDestination\":{}}],\"pnrHeader\":[{\"reservationInfo\":{\"reservation\":[{\"companyId\":\"1A\",\"controlNumber\":\"T9IVSW\",\"date\":\"080119\",\"time\":401}]}}],\"pnrHeaderTag\":{\"statusInformation\":[{\"indicator\":\"TST\"},{\"indicator\":\"RLR\"},{\"indicator\":\"SFP\"}]},\"sbrCreationPosDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"US\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"1A\",\"locationId\":\"NYC\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"NYCM0210Y\",\"originatorId\":33643271},\"originatorTypeCode\":\"T\"}},\"sbrPOSDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"US\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"1A\",\"locationId\":\"NYC\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"NYCM0210Y\",\"originatorId\":33643271},\"originatorTypeCode\":\"T\"}},\"sbrUpdatorPosDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"US\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"1A\",\"locationId\":\"NYC\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"NYCM02100\",\"originatorId\":33643271},\"originatorTypeCode\":\"T\"}},\"securityInformation\":{\"cityCode\":\"SZX\",\"queueingInformation\":{\"queueingOfficeId\":\"NYCM0210Y\"},\"responsibilityInformation\":{\"agentId\":\"ACGS\",\"iataCode\":\"33643271\",\"officeId\":\"NYCM0210Y\",\"typeOfPnrElement\":\"RP\"},\"secondRpInformation\":{\"agentSignature\":\"9999WS\",\"creationDate\":\"080119\",\"creationOfficeId\":\"NYCM0210Y\",\"creationTime\":\"0206\",\"creatorIataCode\":\"33643271\"}},\"segmentGroupingInfo\":[],\"technicalData\":{\"enveloppeNumberData\":{\"sequenceDetails\":{\"number\":\"6\"}},\"lastTransmittedEnvelopeNumber\":{\"currentRecord\":5},\"purgeDateData\":{\"dateTime\":{\"day\":\"20\",\"month\":\"1\",\"year\":2019}}},\"travellerInfo\":[{\"elementManagementPassenger\":{\"lineNumber\":1,\"reference\":{\"number\":2,\"qualifier\":\"PT\"},\"segmentName\":\"NM\"},\"enhancedPassengerData\":[{\"enhancedTravellerInformation\":{\"otherPaxNamesDetails\":[{\"displayedName\":\"Y\",\"givenName\":\"HONGMEI MS\",\"nameType\":\"UN\",\"referenceName\":\"Y\",\"surname\":\"HU\"}],\"travellerNameInfo\":{\"quantity\":1}}}],\"passengerData\":[{\"travellerInformation\":{\"passenger\":[{\"firstName\":\"HONGMEI MS\"}],\"traveller\":{\"quantity\":1,\"surname\":\"HU\"}}}]},{\"elementManagementPassenger\":{\"lineNumber\":2,\"reference\":{\"number\":3,\"qualifier\":\"PT\"},\"segmentName\":\"NM\"},\"enhancedPassengerData\":[{\"enhancedTravellerInformation\":{\"otherPaxNamesDetails\":[{\"displayedName\":\"Y\",\"givenName\":\"PEI MS\",\"nameType\":\"UN\",\"referenceName\":\"Y\",\"surname\":\"SHANG\"}],\"travellerNameInfo\":{\"quantity\":1}}}],\"passengerData\":[{\"travellerInformation\":{\"passenger\":[{\"firstName\":\"PEI MS\"}],\"traveller\":{\"quantity\":1,\"surname\":\"SHANG\"}}}]}],\"tstData\":[]}";
		String str = "{\"dataElementsMaster\":{\"dataElementsIndiv\":[{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":5,\"reference\":{\"number\":2,\"qualifier\":\"OT\"},\"segmentName\":\"AP\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"5\"},\"longFreetext\":\"13602567717\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":6,\"reference\":{\"number\":1,\"qualifier\":\"OT\"},\"segmentName\":\"AP\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P02\"},\"longFreetext\":\"FEINAGUOJI@163.COM\"}],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":7,\"reference\":{\"number\":7,\"qualifier\":\"OT\"},\"segmentName\":\"TK\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[],\"ticketElement\":{\"ticket\":{\"date\":\"110319\",\"indicator\":\"TL\",\"officeId\":\"TPEW123DU\",\"sitaAddress\":[]}}},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":8,\"reference\":{\"number\":10,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"2\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"3U\",\"freeText\":[\"P/CN/E78440908/CN/19JUL89/M/10APR26/CHEN/XI MR/H\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":9,\"reference\":{\"number\":11,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"2\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"3U\",\"freeText\":[\"P/CN/E78440908/CN/19JUL89/M/10APR26/CHEN/XI MR/H\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":10,\"reference\":{\"number\":12,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"3U\",\"freeText\":[\"P/CN/G55621695/CN/16OCT86/M/18OCT21/PU/HAO MR/H\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":11,\"reference\":{\"number\":13,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"3U\",\"freeText\":[\"P/CN/G55621695/CN/16OCT86/M/18OCT21/PU/HAO MR/H\"],\"quantity\":1,\"status\":\"HK\",\"type\":\"DOCS\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":12,\"reference\":{\"number\":17,\"qualifier\":\"OT\"},\"segmentName\":\"SSR\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[],\"railSeatDetails\":[],\"seatPaxInfo\":[],\"serviceRequest\":{\"ssr\":{\"companyId\":\"1A\",\"freeText\":[\"BY TPE13JAN19/1152 OR CXL 3U8085 R11MAR\"],\"status\":\" \",\"type\":\"ADTK\"},\"ssrb\":[]},\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":13,\"reference\":{\"number\":8,\"qualifier\":\"OT\"},\"segmentName\":\"FE\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"10\"},\"longFreetext\":\"PAX Q/NONENDORSABLE REBOOKING REFUND SUBJECT PENALTY\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]},{\"accessLevel\":[],\"elementManagementData\":{\"lineNumber\":14,\"reference\":{\"number\":9,\"qualifier\":\"OT\"},\"segmentName\":\"FV\"},\"elementsIndicators\":[],\"monetaryInformation\":[],\"otherDataFreetext\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P18\"},\"longFreetext\":\"PAX 3U\"}],\"railSeatDetails\":[],\"referenceForDataElement\":{\"reference\":[{\"number\":\"1\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"ST\"},{\"number\":\"2\",\"qualifier\":\"PT\"},{\"number\":\"3\",\"qualifier\":\"PT\"}]},\"seatPaxInfo\":[],\"ssrPackageInformation\":[],\"structuredFop\":[]}],\"marker2\":{}},\"freeFormText\":[],\"freetextData\":[{\"freetextDetail\":{\"subjectQualifier\":\"3\",\"type\":\"P12\"},\"longFreetext\":\"--- TST RLR ---\"}],\"generalErrorInfo\":[],\"historyData\":[],\"originDestinationDetails\":[{\"extendedContentGroup\":[],\"itineraryInfo\":[{\"elementManagementItinerary\":{\"lineNumber\":3,\"reference\":{\"number\":1,\"qualifier\":\"ST\"},\"segmentName\":\"AIR\"},\"flightDetail\":{\"arrivalStationInfo\":{\"terminal\":\"1\"},\"departureInformation\":{\"departTerminal\":\"1\"},\"facilities\":[{\"entertainement\":\"M\",\"entertainementDescription\":\"S\",\"productExtensionCode\":[]}],\"productDetails\":{\"equipment\":\"330\",\"numOfStops\":0,\"weekDay\":1}},\"flixInfo\":[],\"generalOption\":[],\"insuranceInformation\":[],\"itineraryMessageAction\":{\"business\":{\"function\":\"1\"}},\"itineraryReservationInfo\":{\"reservation\":{\"companyId\":\"3U\",\"controlNumber\":\"MDW576\"}},\"itineraryfreeFormText\":[],\"legInfo\":[],\"markerRailTour\":{},\"relatedProduct\":{\"quantity\":2,\"status\":[\"HK\"]},\"selectionDetails\":{\"selection\":[{\"option\":\"P2\"}]},\"taxInformation\":[],\"travelProduct\":{\"boardpointDetail\":{\"cityCode\":\"CTU\"},\"companyDetail\":{\"identification\":\"3U\"},\"offpointDetail\":{\"cityCode\":\"NRT\"},\"product\":{\"arrDate\":\"110319\",\"arrTime\":\"1900\",\"depDate\":\"110319\",\"depTime\":\"1330\"},\"productDetails\":{\"classOfService\":\"R\",\"identification\":\"8085\"},\"typeDetail\":{\"detail\":\"ET\"}}},{\"elementManagementItinerary\":{\"lineNumber\":4,\"reference\":{\"number\":2,\"qualifier\":\"ST\"},\"segmentName\":\"AIR\"},\"flightDetail\":{\"arrivalStationInfo\":{\"terminal\":\"1\"},\"departureInformation\":{\"departTerminal\":\"1\"},\"facilities\":[{\"entertainement\":\"M\",\"entertainementDescription\":\"S\",\"productExtensionCode\":[]}],\"productDetails\":{\"equipment\":\"330\",\"numOfStops\":0,\"weekDay\":1}},\"flixInfo\":[],\"generalOption\":[],\"insuranceInformation\":[],\"itineraryMessageAction\":{\"business\":{\"function\":\"1\"}},\"itineraryReservationInfo\":{\"reservation\":{\"companyId\":\"3U\",\"controlNumber\":\"MDW576\"}},\"itineraryfreeFormText\":[],\"legInfo\":[],\"markerRailTour\":{},\"relatedProduct\":{\"quantity\":2,\"status\":[\"HK\"]},\"selectionDetails\":{\"selection\":[{\"option\":\"P2\"}]},\"taxInformation\":[],\"travelProduct\":{\"boardpointDetail\":{\"cityCode\":\"NRT\"},\"companyDetail\":{\"identification\":\"3U\"},\"offpointDetail\":{\"cityCode\":\"CTU\"},\"product\":{\"arrDate\":\"190319\",\"arrTime\":\"0135\",\"dayChangeIndicator\":1,\"depDate\":\"180319\",\"depTime\":\"2030\"},\"productDetails\":{\"classOfService\":\"R\",\"identification\":\"8086\"},\"typeDetail\":{\"detail\":\"ET\"}}}],\"originDestination\":{}}],\"pnrHeader\":[{\"reservationInfo\":{\"reservation\":[{\"companyId\":\"1A\",\"controlNumber\":\"TGF45V\",\"date\":\"080119\",\"time\":352}]}}],\"pnrHeaderTag\":{\"statusInformation\":[{\"indicator\":\"TST\"},{\"indicator\":\"RLR\"}]},\"sbrCreationPosDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"TW\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"1A\",\"locationId\":\"TPE\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"TPEW123DU\"},\"originatorTypeCode\":\"T\"}},\"sbrPOSDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"TW\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"1A\",\"locationId\":\"TPE\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"TPEW123DU\"},\"originatorTypeCode\":\"T\"}},\"sbrUpdatorPosDetails\":{\"sbrPreferences\":{\"userPreferences\":{\"codedCountry\":\"CN\"}},\"sbrSystemDetails\":{\"deliveringSystem\":{\"companyId\":\"CA\",\"locationId\":\"PEK\"}},\"sbrUserIdentificationOwn\":{\"originIdentification\":{\"inHouseIdentification1\":\"PEKCA1TTY\"},\"originatorTypeCode\":\"A\"}},\"securityInformation\":{\"cityCode\":\"SZX\",\"queueingInformation\":{\"queueingOfficeId\":\"TPEW123DU\"},\"responsibilityInformation\":{\"agentId\":\"CARM\",\"officeId\":\"TPEW123DU\",\"typeOfPnrElement\":\"RP\"},\"secondRpInformation\":{\"agentSignature\":\"9998WS\",\"creationDate\":\"080119\",\"creationOfficeId\":\"TPEW123DU\",\"creationTime\":\"0352\"}},\"segmentGroupingInfo\":[],\"technicalData\":{\"enveloppeNumberData\":{\"sequenceDetails\":{\"number\":\"2\"}},\"lastTransmittedEnvelopeNumber\":{\"currentRecord\":1},\"purgeDateData\":{\"dateTime\":{\"day\":\"22\",\"month\":\"3\",\"year\":2019}}},\"travellerInfo\":[{\"elementManagementPassenger\":{\"lineNumber\":1,\"reference\":{\"number\":2,\"qualifier\":\"PT\"},\"segmentName\":\"NM\"},\"enhancedPassengerData\":[{\"enhancedTravellerInformation\":{\"otherPaxNamesDetails\":[{\"displayedName\":\"Y\",\"givenName\":\"XI MR\",\"nameType\":\"UN\",\"referenceName\":\"Y\",\"surname\":\"CHEN\"}],\"travellerNameInfo\":{\"quantity\":1,\"type\":\"ADT\"}}}],\"passengerData\":[{\"travellerInformation\":{\"passenger\":[{\"firstName\":\"XI MR\",\"type\":\"ADT\"}],\"traveller\":{\"quantity\":1,\"surname\":\"CHEN\"}}}]},{\"elementManagementPassenger\":{\"lineNumber\":2,\"reference\":{\"number\":3,\"qualifier\":\"PT\"},\"segmentName\":\"NM\"},\"enhancedPassengerData\":[{\"enhancedTravellerInformation\":{\"otherPaxNamesDetails\":[{\"displayedName\":\"Y\",\"givenName\":\"HAO MR\",\"nameType\":\"UN\",\"referenceName\":\"Y\",\"surname\":\"PU\"}],\"travellerNameInfo\":{\"quantity\":1,\"type\":\"ADT\"}}}],\"passengerData\":[{\"travellerInformation\":{\"passenger\":[{\"firstName\":\"HAO MR\",\"type\":\"ADT\"}],\"traveller\":{\"quantity\":1,\"surname\":\"PU\"}}}]}],\"tstData\":[]}";
		JSONObject parseObject = JSON.parseObject(str);
		
		String aDpt = JSONPath.eval(parseObject, "$..boardpointDetail.cityCode")
				.toString();

		String aArr = JSONPath.eval(parseObject, "$..offpointDetail.cityCode")
				.toString();
		
		
		
//		String aDpt = split[0].trim();
//		String aArr = split[1].trim();
		
		System.out.println(aDpt);
		System.out.println(aArr);
		
		
		
//		String string = JSONPath.eval(parseObject, "$..identification").toString();
//		System.out.println("string:"+string);
		
//		String string = JSONPath.eval(parseObject, "$..identification[0,1]").toString().replace("[", "").replace("]", "").replace(", ", "");
//		System.out.println("string:"+string);
		
//		JSONArray travellerInfoJsonArray = parseObject.getJSONArray("travellerInfo");
//		String names = "";
//		for(int i=0;i<travellerInfoJsonArray.size();i++) {
//			String surname = JSONPath.eval(travellerInfoJsonArray.get(i), 
//					"$.enhancedPassengerData..otherPaxNamesDetails..surname").toString().replace("[", "").replace("]", "");
//			String givenName = JSONPath.eval(travellerInfoJsonArray.get(i),
//					"$.enhancedPassengerData..otherPaxNamesDetails..givenName").toString().replace("[", "").replace("]", "");
//			String name = surname+"/"+givenName;
//			names += name+";";
//		}
//		System.out.println("所有乘机人姓名:"+names);
//		
//		String[] split = JSONPath.eval(parseObject, "$..boardpointDetail.cityCode")
//				.toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
//		String depDate = JSONPath.eval(parseObject, "$..depDate[0]").toString();
//		String depTime = JSONPath.eval(parseObject, "$..depTime[0]").toString();
//		System.out.println(split[0].trim());
//		System.out.println(split[1].trim());
//		System.out.println(depDate);
//		System.out.println(depTime);
		
		

		
		
		
		
	}
	
	
	

	/**
	 * model转JSON
	 */
	@Test
	public void test1() {
		JSONVo jsonVo = new JSONVo();
		jsonVo.setId(1);
		jsonVo.setName("张三");
		jsonVo.setTime(new Date());
		String json = JSON.toJSONString(jsonVo);
		System.out.println(json);
		String jsonStr = JSON.toJSONString(jsonVo);
		System.out.println(jsonStr);
	}
	
	/**
	 * JSON格式的字符串转json
	 */
	@Test
	public void test2() {
		String jsonStr = "{\"id\":1,\"name\":\"张三\",\"time\":1527151012852}";
		JSONObject json = JSONObject.parseObject(jsonStr);
		Integer id = Integer.parseInt(json.getString("id"));
		String name = json.getString("name");
		System.out.println("id: "+id+",name: "+name);
		System.out.println(json.toJSONString());
	}
	
	/**
	 * json对象直接转model
	 */
	@Test
	public void test3() {
		JSONObject json = JSONObject.parseObject("{\"id\":1,\"name\":\"张三\",\"time\":1527151012852}");
		JSONVo vo = JSONObject.toJavaObject(json, JSONVo.class);
		System.out.println(vo.toString());
	}
	
	/**
	 * JSONArray
	 */
	@Test
	public void test4() {
		// add
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<3;i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id_"+i, 1);
			jsonObject.put("name_"+i, "zyg");
			jsonObject.put("date_"+i, new Date());
			jsonArray.add(jsonObject);
		}
		String allStr = jsonArray.toJSONString();
		System.out.println(allStr);
		
		//遍历
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			System.out.println(json.toJSONString());
		}
		
	}
	
	@Test
	public void test5() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("169-7125888195", "校验成功");
		map.put("169-7125888196", "校验成功");
		
		JSONObject json = new JSONObject();
		json.put("id", "111");
		json.put("ticketStatus", map);
		System.out.println(json.toString());
		
		Map<String, String> map1 = (Map<String, String>) json.get("ticketStatus");
		System.out.println(map1);
		for(String key : map1.keySet()) {
			System.out.println(key);
			System.out.println(map1.get(key));
		}
		
	}	
}











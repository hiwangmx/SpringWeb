<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/SpringWeb/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/SpringWeb/js/Highcharts-4.0.3/js/highcharts.js"></script>

<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Snow depth at Vikjafjellet, Norway'
        },
        subtitle: {
            text: 'Irregular time data in Highcharts JS'
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: { // don't display the dummy year
            	hour: '%H:%M',
            	day: '%H:%M',
            },
            tickInterval:3600000
        },
        yAxis: {
            title: {
                text: 'Snow depth (m)'
            },
            min: 0
        },
        tooltip: {
            formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                    Highcharts.dateFormat('%e. %b', this.x) +': '+ this.y +' m';
            }
        },
        credits: {  
            enabled: true,     //去掉highcharts网站url  
            text:"华云数据",
            href : ""
        },
        series: [{
            name: 'Winter 2007-2008',
            data: [
				[Date.UTC(2014, 10, 31, 0, 5), 0   ],
				[Date.UTC(2014, 10, 31, 0,10), 0.1   ],
				[Date.UTC(2014, 10, 31, 0, 15), 0.6   ],
				[Date.UTC(2014, 10, 31, 0, 20), 0.8   ],
				[Date.UTC(2014, 10, 31, 0, 25), 0.5   ],
				[Date.UTC(2014, 10, 31, 0, 30), 0.3   ],
				[Date.UTC(2014, 10, 31, 0, 35), 0.4   ],
				[Date.UTC(2014, 10, 31, 0, 40), 0.9   ],
				[Date.UTC(2014, 10, 31, 0, 45), 0.5   ],
				[Date.UTC(2014, 10, 31, 0, 50), 0   ],
				[Date.UTC(2014, 10, 31, 0, 55), 0.2   ],
				
				[Date.UTC(2014, 10, 31, 1, 0), 0.5   ],
				[Date.UTC(2014, 10, 31, 1, 5), 0.2   ],
				[Date.UTC(2014, 10, 31, 1,10), 0.1   ],
				[Date.UTC(2014, 10, 31, 1, 15), 0.6   ],
				[Date.UTC(2014, 10, 31, 1, 20), 0.4   ],
				[Date.UTC(2014, 10, 31, 1, 25), 0   ],
				[Date.UTC(2014, 10, 31, 1, 30), 0.7   ],
				[Date.UTC(2014, 10, 31, 1, 35), 0.2   ],
				[Date.UTC(2014, 10, 31, 1, 40), 0.5   ],
				[Date.UTC(2014, 10, 31, 1, 45), 0.8   ],
				[Date.UTC(2014, 10, 31, 1, 50), 0.6   ],
				[Date.UTC(2014, 10, 31, 1, 55), 0.6   ],
				
				[Date.UTC(2014, 10, 31, 2, 0), 0   ],
				[Date.UTC(2014, 10, 31, 2, 5), 0.5   ],
				[Date.UTC(2014, 10, 31, 2,10), 0.8   ],
				[Date.UTC(2014, 10, 31, 2, 15), 0.6   ],
				[Date.UTC(2014, 10, 31, 2, 20), 0.4   ],
				[Date.UTC(2014, 10, 31, 2, 25), 0.3   ],
				[Date.UTC(2014, 10, 31, 2, 30), 0.2   ],
				[Date.UTC(2014, 10, 31, 2, 35), 0.2   ],
				[Date.UTC(2014, 10, 31, 2, 40), 0.1   ],
				[Date.UTC(2014, 10, 31, 2, 45), 0.1   ],
				[Date.UTC(2014, 10, 31, 2, 50), 0.5   ],
				[Date.UTC(2014, 10, 31, 2, 55), 0.5   ],
				
				[Date.UTC(2014, 10, 31, 3, 0), 0.9   ],
				[Date.UTC(2014, 10, 31, 3, 5), 0.5   ],
				[Date.UTC(2014, 10, 31, 3,10), 0.4   ],
				[Date.UTC(2014, 10, 31, 3, 15), 0.8   ],
				[Date.UTC(2014, 10, 31, 3, 20), 0.9   ],
				[Date.UTC(2014, 10, 31, 3, 25), 0.4   ],
				[Date.UTC(2014, 10, 31, 3, 30), 0.7   ],
				[Date.UTC(2014, 10, 31, 3, 35), 0.6   ],
				[Date.UTC(2014, 10, 31, 3, 40), 1   ],
				[Date.UTC(2014, 10, 31, 3, 45), 0.8   ],
				[Date.UTC(2014, 10, 31, 3, 50), 0.1   ],
				[Date.UTC(2014, 10, 31, 3, 55), 0   ],
				
				[Date.UTC(2014, 10, 31, 4, 0), 0.8   ],
				[Date.UTC(2014, 10, 31, 4, 5), 0.9   ],
				[Date.UTC(2014, 10, 31, 4,10), 0.4   ],
				[Date.UTC(2014, 10, 31, 4, 15), 0.4   ],
				[Date.UTC(2014, 10, 31, 4, 20), 0.8   ],
				[Date.UTC(2014, 10, 31, 4, 25), 0.6   ],
				[Date.UTC(2014, 10, 31, 4, 30), 0.7   ],
				[Date.UTC(2014, 10, 31, 4, 35), 0.6   ],
				[Date.UTC(2014, 10, 31, 4, 40), 0.7   ],
				[Date.UTC(2014, 10, 31, 4, 45), 0.7   ],
				[Date.UTC(2014, 10, 31, 4, 50), 0.1   ],
				[Date.UTC(2014, 10, 31, 4, 55), 0.8   ],
				
				[Date.UTC(2014, 10, 31, 5, 0), 0.4   ],
				[Date.UTC(2014, 10, 31, 5, 5), 0.4   ],
				[Date.UTC(2014, 10, 31, 5,10), 0.3   ],
				[Date.UTC(2014, 10, 31, 5, 15), 0.5   ],
				[Date.UTC(2014, 10, 31, 5, 20), 0.7   ],
				[Date.UTC(2014, 10, 31, 5, 25), 0.8   ],
				[Date.UTC(2014, 10, 31, 5, 30), 0.5   ],
				[Date.UTC(2014, 10, 31, 5, 35), 0.7   ],
				[Date.UTC(2014, 10, 31, 5, 40), 0.4   ],
				[Date.UTC(2014, 10, 31, 5, 45), 0   ],
				[Date.UTC(2014, 10, 31, 5, 50), 0.1   ],
				[Date.UTC(2014, 10, 31, 5, 55), 0.6   ],
				
				[Date.UTC(2014, 10, 31, 6, 0), 0.9   ],
				[Date.UTC(2014, 10, 31, 6, 5), 0.4   ],
				[Date.UTC(2014, 10, 31, 6,10), 0.4 ],
				[Date.UTC(2014, 10, 31, 6, 15), 0.8   ],
				[Date.UTC(2014, 10, 31, 6, 20), 0.6   ],
				[Date.UTC(2014, 10, 31, 6, 25), 0.4   ],
				[Date.UTC(2014, 10, 31, 6, 30), 0   ],
				[Date.UTC(2014, 10, 31, 6, 35), 0.1   ],
				[Date.UTC(2014, 10, 31, 6, 40), 0.6   ],
				[Date.UTC(2014, 10, 31, 6, 45), 0.7   ],
				[Date.UTC(2014, 10, 31, 6, 50), 0.8   ],
				[Date.UTC(2014, 10, 31, 6, 55), 0.9   ],
				
				[Date.UTC(2014, 10, 31, 7, 0), 0.1   ],
				[Date.UTC(2014, 10, 31, 7, 5), 0   ],
				[Date.UTC(2014, 10, 31, 7,10), 0   ],
				[Date.UTC(2014, 10, 31, 7, 15), 0.6   ],
				[Date.UTC(2014, 10, 31, 7, 20), 0.4   ],
				[Date.UTC(2014, 10, 31, 7, 25), 0.8   ],
				[Date.UTC(2014, 10, 31, 7, 30), 0.9   ],
				[Date.UTC(2014, 10, 31, 7, 35), 0.7   ],
				[Date.UTC(2014, 10, 31, 7, 40), 0.9   ],
				[Date.UTC(2014, 10, 31, 7, 45), 0.7   ],
				[Date.UTC(2014, 10, 31, 7, 50), 0.6   ],
				[Date.UTC(2014, 10, 31, 7, 55), 1   ],
				
				[Date.UTC(2014, 10, 31, 8, 0), 0.7   ],
				[Date.UTC(2014, 10, 31, 8, 5), 0.4   ],
				[Date.UTC(2014, 10, 31, 8,10), 0.6   ],
				[Date.UTC(2014, 10, 31, 8, 15), 0.4   ],
				[Date.UTC(2014, 10, 31, 8, 20), 0.8   ],
				[Date.UTC(2014, 10, 31, 8, 25), 0.5   ],
				[Date.UTC(2014, 10, 31, 8, 30), 1   ],
				[Date.UTC(2014, 10, 31, 8, 35), 0.4   ],
				[Date.UTC(2014, 10, 31, 8, 40), 0.1   ],
				[Date.UTC(2014, 10, 31, 8, 45), 0   ],
				[Date.UTC(2014, 10, 31, 8, 50), 0.8   ],
				[Date.UTC(2014, 10, 31, 8, 55), 0.4   ],
				
				[Date.UTC(2014, 10, 31, 9, 0), 0.1   ],
				[Date.UTC(2014, 10, 31, 9, 5), 0.8   ],
				[Date.UTC(2014, 10, 31, 9,10), 0.6   ],
				[Date.UTC(2014, 10, 31, 9, 15), 0.4   ],
				[Date.UTC(2014, 10, 31, 9, 20), 0.6   ],
				[Date.UTC(2014, 10, 31, 9, 25), 0.1   ],
				[Date.UTC(2014, 10, 31, 9, 30), 0.9   ],
				[Date.UTC(2014, 10, 31, 9, 35), 0.5   ],
				[Date.UTC(2014, 10, 31, 9, 40), 0.6   ],
				[Date.UTC(2014, 10, 31, 9, 45), 0.1   ],
				[Date.UTC(2014, 10, 31, 9, 50), 0   ],
				[Date.UTC(2014, 10, 31, 9, 55), 0.3   ],
				
				[Date.UTC(2014, 10, 31, 10, 0), 0   ],
				[Date.UTC(2014, 10, 31, 10, 5), 0.6   ],
				[Date.UTC(2014, 10, 31, 10,10), 0.9   ],
				[Date.UTC(2014, 10, 31, 10, 15), 0.1   ],
				[Date.UTC(2014, 10, 31, 10, 20), 0.3   ],
				[Date.UTC(2014, 10, 31, 10, 25), 0.5   ],
				[Date.UTC(2014, 10, 31, 10, 30), 0.3   ],
				[Date.UTC(2014, 10, 31, 10, 35), 0.4   ],
				[Date.UTC(2014, 10, 31, 10, 40), 0.1   ],
				[Date.UTC(2014, 10, 31, 10, 45), 0.2   ],
				[Date.UTC(2014, 10, 31, 10, 50), 0.3   ],
				[Date.UTC(2014, 10, 31, 10, 55), 0.4   ],
				
				[Date.UTC(2014, 10, 31, 11, 0), 0.7   ],
				[Date.UTC(2014, 10, 31, 11, 5), 0   ],
				[Date.UTC(2014, 10, 31, 11,10), 0.1   ],
				[Date.UTC(2014, 10, 31, 11, 15), 0.1   ],
				[Date.UTC(2014, 10, 31, 11, 20), 0.5   ],
				[Date.UTC(2014, 10, 31, 11, 25), 0.4   ],
				[Date.UTC(2014, 10, 31, 11, 30), 0.2   ],
				[Date.UTC(2014, 10, 31, 11, 35), 0.6   ],
				[Date.UTC(2014, 10, 31, 11, 40), 0.4   ],
				[Date.UTC(2014, 10, 31, 11, 45), 0.7   ],
				[Date.UTC(2014, 10, 31, 11, 50), 0.4   ],
				[Date.UTC(2014, 10, 31, 11, 55), 0.3   ],
            ]
        }]
    });
});				
</script>
</head>
<body>

	<div id="container" style="width: 700px; height: 400px"></div>

</body>
</html>
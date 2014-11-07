Highcharts.setOptions({
	lang: {
		months: ['01', '02', '03', '04', '05', '06',  '07', '08', '09', '10', '11', '12'],
		shortMonths : ['01', '02', '03', '04', '05', '06',  '07', '08', '09', '10', '11', '12'],
		weekdays: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
	},
	global:{
		useUTC: false
	}
});

function chartToday(title, subtitle, YText, data){
	var myDate = new Date();
	var hours = myDate.getHours();
	var interval = 0;
	if(hours >= 12){
		interval = 3600000 * 2;
	}else{
		interval = 3600000;
	}
	showChart(title, subtitle, YText, data, interval);
}

function chartYesterday(title, subtitle, YText, data){
	var interval = 3600000 * 2;
	showChart(title, subtitle, YText, data, interval);
}

function chartWeek(title, subtitle, YText, data){
	var interval = 3600000 * 24;
	showChart(title, subtitle, YText, data, interval, "%b-%e");
}

function chartHalfMouth(title, subtitle, YText, data){
	var interval = 3600000 * 24;
	showChart(title, subtitle, YText, data, interval, "%b-%e");
}

function showChart(title, subtitle, YText, data, interval, xShowDayFormat){
	if(xShowDayFormat == null || xShowDayFormat == ""){
		xShowDayFormat = "%H:%M";
	}
	
	$('#container').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: title
        },
        subtitle: {
            text: subtitle
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: { // don't display the dummy year
            	hour: '%H:%M',
            	day: xShowDayFormat,
            },
            tickInterval:interval
        },
        yAxis: {
            title: {
                text: YText
            },
            min: 0
        },
        tooltip: {
            formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                    Highcharts.dateFormat('%Y-%b-%e %H:%M', this.x) +','+ this.y;
            }
        },
        credits: {  
            enabled: true,     //去掉highcharts网站url  
            text:"华云数据",
            href : ""
        },
        series: data
    });
}
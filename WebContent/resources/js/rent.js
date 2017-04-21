/**
 * Created by Masic on 18.4.2017..
 */
var url = 'http://query.yahooapis.com/v1/public/yql?q=select * from yahoo.finance.xchange where pair in ("HRKEUR")&format=json&env=store://datatables.org/alltableswithkeys';
var omjer;
$.get(url, function (data) {
    omjer = data.query.results.rate.Rate;

    $("#price").html(($("#priceInput").attr("value") * omjer).toFixed(2));
});
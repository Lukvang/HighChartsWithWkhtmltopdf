package JS;

public enum HighChartsJavaScriptGenerator {
	

	ADD_BEGINNING_BRACKET() {
		@Override
		public String generate(String id) {
			return "Highcharts.chart('" + id + "', {";
		}
	},
	ADD_TITLE() {
		@Override
		public String generate(String title) {
			return "title: { text: '" + title + "'},";
		}
	},
	ADD_SUBTITLE() {
		@Override
		public String generate(String subtitle) {
			return "subtitle: { text: '" + subtitle + "}'},";
		}
	},
	ADD_X_AXIS_TITLE() {
		@Override
		public String generate(String title) {
			return "yAxis: { title: {text: '" + title + "' }},";
		}
	},
	ADD_PLOT_OPTINS(){
		@Override
		public String generate(String pointStart){
			return "plotOptions: { series: { pointStart: " + pointStart + " , animation: false } },";
		}
	},
	ADD_SERIES(){
		@Override 
		public String generate(String JSON){
			return " series: [ " + JSON + "]";
		}
	},
	ADD_ENDING_BRACKET(){
		@Override
		public String generate(String id) {
			return "});";
		}
	};

	public abstract String generate(String input);

}

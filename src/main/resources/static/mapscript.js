mymap = L.map('mapid').setView([41.11148, 16.8554], 14);
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
    maxZoom: 18,
    attribution: 'Diploma Thesis &copy;',
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1
}).addTo(mymap);


// function addPin(long, lang) {
//     var marker = L.marker([long, lang]).addTo(mymap);
//     marker.bindPopup("<b>Hello world!</b><br>I am a popup.")
// }
//
// function addCircle(long, lang) {
//     var circle = L.circle([long, lang], {
//         color: 'red',
//         fillColor: '#f03',
//         fillOpacity: 0.5,
//         radius: 1000
//     }).addTo(mymap);
//
//
// }

// var marker = L.marker([37.95, 23.64]).addTo(mymap);
//


// var polygon = L.polygon([
//     [51.509, -0.08],
//     [51.503, -0.06],
//     [51.51, -0.047]
// ]).addTo(mymap);

// marker.bindPopup("<b>Hello world!</b><br>I am a popup.")
// circle.bindPopup("I am a circle.");
//polygon.bindPopup("I am a polygon.");

// function onMapClick(e) {
//     alert("You clicked the map at " + e.latlng);
// }
// mymap.on("click",onMapClick);
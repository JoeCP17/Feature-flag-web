$(document).ready(function() {
  fetchFeatureFlags();

  // Feature Flag 리스트를 불러와 테이블에 채우는 함수
  function fetchFeatureFlags() {
    $.getJSON("/api/v1/feature-flag/list", function(data) {
      var rows = '';
      data.forEach(function(flag) {
        rows += '<tr>' +
            '<td>' + flag.id + '</td>' +
            '<td>' + flag.name + '</td>' +
            '<td><button onclick="toggleFeatureFlag(' + flag.id + ')">Toggle</button></td>' +
            '<td><button onclick="deleteFeatureFlag(' + flag.id + ')">삭제</button></td>' +
            '</tr>';
      });
      $('#feature-flag-list').html(rows);
    });
  }

  // Toggle 버튼이 클릭될 때 호출되는 함수
  window.toggleFeatureFlag = function(id) {
    $.post("/api/v1/feature-flag/" + id, function() {
      fetchFeatureFlags(); // 상태 변경 후 리스트를 다시 불러옴
    });
  };

  // 삭제 버튼이 클릭될 때 호출되는 함수
  window.deleteFeatureFlag = function(id) {
    $.ajax({
      url: "/api/v1/delete/" + id,
      type: 'DELETE',
      success: function() {
        fetchFeatureFlags(); // 삭제 후 리스트를 다시 불러옴
      }
    });
  };
});

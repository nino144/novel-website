import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChapterContentService {

  constructor() { }

  getChapterOverview() {
    return {
      novelName: 'The Great Adventure',
      chapterName: 'Chapter 5: Into the Unknown',
    };
  }
  getChapterContent(): string {
    return `
          Thứ 1 chương Gloucester thiếu niên
          “Phật lợi sâm tiên sinh, nữ sĩ, còn xin bên này, thời gian này tiểu Brian bình thường đều ở hậu viện tượng thụ nhìn xuống sách.”
          Julie sao nữ sĩ trên mặt tươi cười, lộ ra càng hiền lành.
          Phật lợi sâm thái thái cau mày, có một chút nghi hoặc: “Đứa nhỏ này, có phải hay không có chút quá...... Ý của ta là, quá quái gở ?”
          “Không không không, phật lợi sâm nữ sĩ.” Julie sao vội vàng trả lời, “Tiểu Brian chỉ là có chút không thích nói chuyện, trên thực tế bằng hữu của hắn rất nhiều, trong viện hài tử đều thích cùng hắn chơi.”
          “Julie An viện trưởng.” Phật lợi sâm tiên sinh ngữ khí rất bình thản. Xem như Gloucester số một luật sư văn phòng đối tác, hắn biết rõ trước mắt vị này viện mồ côi dài muốn che giấu là cái gì.
          “Có thể chúng ta hẳn là trước tiên cùng trong miệng ngươi tiểu Brian trò chuyện chút, dù sao chỉ có mặt đối mặt giao lưu mới có thể càng dễ nhận biết một người, không phải sao?”
          “Đương nhiên......” Julie sao có vẻ hơi co quắp, “Như ngài mong muốn, phật lợi sâm tiên sinh, nữ sĩ.”
          Một nhóm 3 người đi tới Santa Maria viện mồ côi hậu viện, khi thấy một thiếu niên ngồi dựa vào một gốc đại đại tượng thụ phía dưới, trong tay đang nâng một quyển sách. Dương quang xuyên thấu qua tượng thụ dày đặc lá cây rơi xuống dưới, rơi vào trên người thiếu niên, rất là yên tĩnh an tường.
          “Thực sự là một cái soái tiểu tử.” Phật lợi sâm thái thái cười nói, “Có phải hay không, thân yêu?”
          Phật lợi sâm tiên sinh gật đầu một cái, đưa tay phải ra, nói: “Lần đầu gặp mặt, ngươi có thể gọi ta phật lợi sâm tiên sinh, đây là thê tử của ta, ngươi có thể gọi nàng phật lợi sâm thái thái.”
          “Ngài khỏe, phật lợi sâm tiên sinh, phật lợi sâm thái thái.”
          “Julie sao nữ sĩ.” Phật lợi sâm tiên sinh ngữ khí lại bình thản xuống, âm cuối kéo dài rất dài, “Ta nhớ ngài cần cho chúng ta một lời giải thích.”
          “Tiểu Brian, tự ngươi nói một chút đây đều là thứ mấy một cặp bị ngươi cự tuyệt nhận nuôi người?”
          “Từ ta nhớ chuyện lên, đây là đệ thất một cặp.” Brian cúi đầu tránh thoát Julie sao tay, trên mặt vẫn lạnh nhạt như cũ, “Ngài biết đến, ta dù sao có chút......”
          “Đặc thù sao? Hài tử.” Julie sao nói, “Thế nhưng là ngươi không phải đã có thể khống chế sao?”
          “Đương nhiên.” Brian gật đầu một cái, “Nhưng luôn có Nhặt bảovạn nhất, không phải sao? Ai biết có thể hay không lại phát sinh giống năm năm trước chuyện như vậy, ngài biết đến, ta không muốn thương tổn đến người khác.”
          “Cám ơn ngươi, Julie An viện trưởng.” Brian ngẩng đầu, lộ ra một nụ cười xán lạn.
          Julie sao cũng lộ ra ý cười, trả thù tựa như nhéo nhéo Brian khuôn mặt, lại vỗ đầu một cái, bất đắc dĩ đi .
          “Đừng quên giờ cơm tối.”
          Tính danh: Brian · Tư đặc biệt Lai Đức
          Xưng hào: Ma pháp quan tâm giả ( Ma pháp chỉ ở trong số ít người nở rộ, ngươi chính là một trong số đó )
          Tượng thụ thủ hộ ( Tượng thụ sẽ vĩnh viễn thủ hộ lấy ngươi, đương nhiên cái khác cây cũng giống vậy )
          Đại não phong bế sư ( Mê vụ bảo hộ lấy đầu óc của ngươi, cất dấu ngươi bí ẩn nhất bí mật )
          Julie sao yêu nhất ( Không tệ, là ngươi, là ngươi, chính là ngươi )
          Thiên phú: Ma lực sự hòa hợp
          Kỹ năng: Đại não phong bế thuật ( Định chế bản )( Ngươi bí ẩn nhất bí mật sẽ không bị người biết, nếu như ngươi không có nói ra mà nói, đến nỗi cái khác, liền dựa vào chính ngươi )( Không thể thăng cấp )
          Tri thức nắm giữ ( Cùng người khác so sánh, ngươi sẽ nhanh hơn học được kiến thức mới, nhưng cũng chỉ thế thôi )( Không thể thăng cấp )
          Rất đơn giản mấy dòng chữ, lại là Brian đời này bí mật lớn nhất.
          Brian hồi tưởng lại lúc trước ký ức là tại năm tuổi thời điểm, đồng thời còn mang đến Santa Maria viện mồ côi sử thượng nghiêm trọng nhất nguy cơ.
          Đêm hôm đó, Edgecombe tên kỳ diệu làm một cơn ác mộng, trong mộng không ngừng thoáng qua từng màn hoặc cao hứng, hoặc bi thương, hoặc kích động, hoặc thất lạc tràng cảnh. Kèm theo một màn cuối cùng, một cái không rõ sinh vật đột nhiên từ ven đường thoát ra, theo bản năng nhanh phanh lại, tay lái bỗng nhiên lắc một cái......
          Tiếp đó, Brian tỉnh.
          Đập vào tầm mắt chính là một mặt hoảng sợ nhìn hắn Julia viện trưởng, cùng một phòng bay lên đồ vật.
          Brian cũng che lại, theo bản năng muốn cho hết thảy khôi phục nguyên dạng.
          Vạn hạnh, hắn làm được.
          Dù là Brian cũng không biết chính mình đến tột cùng là làm sao làm được.
          Sau đó mấy năm, theo không ngừng thí nghiệm, Brian cuối cùng có thể rất tốt khống chế loại này cùng loại niệm động lực năng lực, chỉ là lại không có cách nào làm được để cho trong nhà tất cả mọi thứ bay lên rồi.
          Đúng vậy, đêm hôm đó bay lên, hơn xa Brian trong phòng những cái kia.
          Bằng không, Julie sao cũng sẽ không bị sợ ước chừng chậm nửa tháng, đi lên lộ mới không phiêu.
          Julia viện trưởng là một cái người rất tốt, xem như đêm đó duy nhất người chứng kiến, nàng cũng không có vì vậy đối với Brian sinh ra một chút như sợ, tâm tình sợ hãi, ngược lại tràn đầy lo lắng. Thường xuyên lặng lẽ tìm Brian tâm sự, đồng thời đưa cho hắn rất nhiều không hiểu thấu sách.
          Tỉ như 《 Nữ vu: Thời Trung cổ loạn lạc căn nguyên 》《 Nữ Vu cùng Hắc Tử Bệnh 》《 Đánh bại quỷ hút máu một trăm loại phương pháp 》《 Ác ma ngay tại bên cạnh ngươi 》《 Thánh Kinh 》《 Bắt đầu từ số không học ma pháp 》......
          Trời có mắt rồi, cũng không biết Julie sao là từ đâu lấy được những thứ này đồ vật loạn thất bát tao .
          Đương nhiên, kết quả cuối cùng là tốt.10 tuổi lúc, Brian liền đã có thể khống chế loại lực lượng này .
          Chờ ở trước mặt Julie sao khống chế 3 cái cục đá nhanh chóng phi hành xuyên thẳng qua sau, Julie sao liền tại ngắn ngủi trong một năm cho Brian tìm 5 cái nhận nuôi gia đình.
          Đương nhiên, dựa vào Julie sao nói chuyện, là năng lực của nàng có hạn, cũng không thể cho Brian rất tốt giáo dục, Brian đáng giá tốt hơn hoàn cảnh cùng tốt hơn giáo dục.
          Điểm này từ cái này 5 cái gia đình về mặt thân phận liền có thể nhìn ra.
          Luật sư, bác sĩ, giáo sư, quản lý, nghiên cứu viên, cũng là nhận qua giáo dục cao đẳng tinh anh nhân sĩ.
          ( Tấu chương xong )`;
  }
}

import request from '@/utils/request'

// 保存页面
export function pageSave(data) {
  return request({
    url: '/api/page/save',
    method: 'post',
    data: data
  })
}
